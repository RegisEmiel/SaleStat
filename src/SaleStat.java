import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SaleStat {
    private final Supplier<Collection<GameStatistics>> statisticsSource;

    public SaleStat(Supplier<Collection<GameStatistics>> statisticsSource) {
        this.statisticsSource = statisticsSource;
    }

    public static void main(String[] args) {
        Long mostIncomeGames = 0L;
        Long leastIncomeGames = 0L;
        Map<Genre, Long> incomeByGenre;

        Map.Entry<String, Long> maxGame;

        SaleStat saleStat = new SaleStat(new StatisticsSource());
        Collection<GameStatistics> gameStatistics = saleStat.statisticsSource.get();

        // Максимальный доход
        mostIncomeGames = gameStatistics.stream()
                .map(s -> (s.sold - s.refunded) * s.price)
                .max(Long::compareTo)
                .get();

        // Минимальный доход
        leastIncomeGames = gameStatistics.stream()
                .map(s -> (s.sold - s.refunded) * s.price)
                .min(Long::compareTo)
                .get();

        // Доход по жанрам
        incomeByGenre = gameStatistics.stream()
                        .collect(Collectors.toMap(s -> s.genre,
                                s -> (s.sold - s.refunded) * s.price,
                                Long::sum,
                                HashMap::new));

        // Игра с максимальным доходом
        maxGame = gameStatistics.stream()
                .collect(Collectors.toMap(s -> s.name,
                        s -> (s.sold - s.refunded) * s.price,
                        Long::sum,
                        HashMap::new))
                .entrySet().stream()
                .max(Map
                        .Entry
                        .comparingByValue(Long::compareTo))
                .get();

        System.out.println("Most income game(s): " + mostIncomeGames);
        System.out.println("Least income game(s): " + leastIncomeGames);
        System.out.println("Income by genre: " + incomeByGenre);

        System.out.println("Most income game(s) with name: " + maxGame);
    }
}
