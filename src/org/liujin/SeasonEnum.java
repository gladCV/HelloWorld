package org.liujin;

/**
 * @author LiuJin
 * @date 2022-08-05 10:29
 */
public enum SeasonEnum {
    SPRING("SPRING", "I love spring."),
    SUMMER("SPRING", "I love spring."),
    AUTUMN("SPRING", "I love spring."),
    WINTER("SPRING", "I love spring.");

    private final String seasonName;
    private final String seasonDesc;

    SeasonEnum(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "SeasonEnum{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
