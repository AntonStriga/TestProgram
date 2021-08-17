import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Consumer {
        private List<NumberData> numberData = new ArrayList<>();

        public void accept(int number) {
                LocalTime creationTime = LocalTime.now();
                final NumberData newNumberData = new NumberData(number, creationTime);
                this.numberData.add(newNumberData);

                LocalTime period = LocalTime.now().minus(Duration.ofMinutes(5));
                this.numberData = getActualNumberData(this.numberData, period);
        }

        public double mean() {
                if (this.numberData.isEmpty()) {
                        return 0;
                }

                LocalTime period = LocalTime.now().minus(Duration.ofMinutes(5));
                final List<NumberData> actualNumberData = getActualNumberData(this.numberData, period);

                return actualNumberData.stream()
                        .mapToInt(NumberData::getValue)
                        .average()
                        .getAsDouble();
        }

        private List<NumberData> getActualNumberData(final Collection<NumberData> sourceNumberData, final LocalTime period) {
                return sourceNumberData.stream()
                        .filter(numberData -> numberData.getCreateTime().compareTo(period) >= 0)
                        .collect(Collectors.toList());
        }

        private static class NumberData {
                private final int value;
                private final LocalTime createTime;

                public NumberData(final int value, final LocalTime createTime) {
                        this.value = value;
                        this.createTime = createTime;
                }

                public int getValue() {
                        return value;
                }

                public LocalTime getCreateTime() {
                        return createTime;
                }
        }
}
