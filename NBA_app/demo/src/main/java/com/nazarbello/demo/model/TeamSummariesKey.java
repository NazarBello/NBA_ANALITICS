
package com.nazarbello.demo.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Composite PK for TeamSeasonStats: season + abbreviation
 */
public class TeamSummariesKey implements Serializable {
    private Integer season;
    private String abbreviation;

    public TeamSummariesKey() {}

    public TeamSummariesKey(Integer season, String abbreviation) {
        this.season = season;
        this.abbreviation = abbreviation;
    }

    // getters & setters
    public Integer getSeason() { return season; }
    public void setSeason(Integer season) { this.season = season; }

    public String getAbbreviation() { return abbreviation; }
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamSummariesKey)) return false;
        TeamSummariesKey that = (TeamSummariesKey) o;
        return Objects.equals(season, that.season)
                && Objects.equals(abbreviation, that.abbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(season, abbreviation);
    }
}
