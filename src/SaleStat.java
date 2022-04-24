import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

public class SaleStat {
    private final Supplier<Collection<GameStatistics>> statisticsSource;

    public SaleStat(Supplier<Collection<GameStatistics>> statisticsSource) {
        this.statisticsSource = statisticsSource;
    }

    public static void main(String[] args) {
        Long mostIncomeGames = 0L;
        Long leastIncomeGames = 0L;
        Map<Genre, Long> incomeByGenre;

        SaleStat saleStat = new SaleStat(new StatisticsSource());
        Collection<GameStatistics> gameStatistics = saleStat.statisticsSource.get();

        mostIncomeGames = gameStatistics.stream()
                .map(s -> s.sold)
                .max(Long::compareTo)
                .get();

        leastIncomeGames = gameStatistics.stream()
                .map(s -> s.sold)
                .min(Long::compareTo)
                .get();

        //ncomeByGenre = gameStatistics.stream();

        System.out.println("Most income game(s): " + mostIncomeGames);
        System.out.println("Least income game(s): " + leastIncomeGames);
        //System.out.println("Income by genre: " + incomeByGenre);
    }
}
