package com.alevel.trucking.model.route.openstreetmap.ru;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMatches {

    private List<Match> matches;

    public ResponseMatches() {
    }

    public ResponseMatches(List<Match> matches) {
        this.matches = matches;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

}
