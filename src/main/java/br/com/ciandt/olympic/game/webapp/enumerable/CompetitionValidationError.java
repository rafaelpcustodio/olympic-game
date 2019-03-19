package br.com.ciandt.olympic.game.webapp.enumerable;

public enum CompetitionValidationError {

    PERIOD_BEGINNING_EMPTY_ERROR("competition.period.begin.empty.error", "The beginning of the competition period is mandatory."),

    PERIOD_ENDING_EMPTY_ERROR("competition.period.end.empty.error", "The ending of the competition period is mandatory."),

    PERIOD_DURATION_ERROR("competition.period.duration.error", "The max duration for a competition is %s, please provide another period."),

    COMPETITOR_EMPTY_ERROR("competition.competitor.empty.error", "The %s competitor is mandatory."),

    PLACE_EMPTY_ERROR("competition.place.empty.error", "The place is mandatory."),

    TYPE_EMPTY_ERROR("competition.type.empty.error", "The type for the competition is mandatory."),

    CONCURRENCY_ERROR("competition.concurrency.error", "There is already a competition happening at the place %s from %s to %s.");

    /**
     * The identifier of the error.
     */
    private String key;

    /**
     * The message that will be shown for the API.
     */
    private String message;

    CompetitionValidationError(final String key, final String message) {
        this.key = key;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }
}
