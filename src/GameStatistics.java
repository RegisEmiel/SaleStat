class GameStatistics {
    /**
     * Название игры
     */
    public final String name;
    /**
     * Жанр игры
     */
    public final Genre genre;
    /**
     * Цена за 1 копию
     */
    public final long price;
    /**
     * Копий продано
     */
    public final long sold;
    /**
     * Копий возвращено
     */
    public final long refunded;

    public GameStatistics(String name, Genre genre, long price, long sold, long refunded) {
        this.name = name;
        this.price = price;
        this.genre = genre;
        this.sold = sold;
        this.refunded = refunded;
    }
}
