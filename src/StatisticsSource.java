import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;

class StatisticsSource implements Supplier<Collection<GameStatistics>> {
    @Override
    public Collection<GameStatistics> get() {
        return Arrays.asList(
                new GameStatistics("Witcher 3", Genre.RPG, 800, 1_000_000, 0),
                new GameStatistics("God of war 4", Genre.RPG, 1200, 834_000, 3),
                new GameStatistics("Last of us 2", Genre.ACTION, 4200, 434_000, 3567),
                new GameStatistics("Dota 2", Genre.STRATEGY, 0, 10_000, 0),
                new GameStatistics("Red Alert", Genre.STRATEGY, 120, 13400, 1)
        );
    }
}
