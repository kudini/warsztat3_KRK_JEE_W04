package pl.coderslab.model;

import java.sql.Date;

public class SolutionsExerciseUsers {
    private int userId;
    private int solutionId;
    private String username;
    private int exerciseId;
    private String exerciseName;
    private Date updated;

    public SolutionsExerciseUsers() {
    }

    public SolutionsExerciseUsers(int userId, String username, int exerciseId, String exerciseName, Date udpated) {
        this.userId = userId;
        this.username = username;
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.updated = udpated;
    }
    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date udpated) {
        this.updated = udpated;
    }
}
