package Model.Entity;

public class Vacancy {
    int idVacancy;
    String vacancyName;
    String description;

    public int getIdVacancy() {
        return idVacancy;
    }

    public void setIdVacancy(int idVacancy) {
        this.idVacancy = idVacancy;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public int getIdCreator() {
        return idCreator;
    }

    public void setIdCreator(int idCreator) {
        this.idCreator = idCreator;
    }

    String requirements;
    int idCreator;

    public Vacancy(int idVacancy, String vacancyName, String description, String requirements) {
        this.idVacancy = idVacancy;
        this.vacancyName = vacancyName;
        this.description = description;
        this.requirements = requirements;
    }

    public Vacancy(int idVacancy, String vacancyName, String description, String requirements, int idCreator) {
        this.idVacancy = idVacancy;
        this.vacancyName = vacancyName;
        this.description = description;
        this.requirements = requirements;
        this.idCreator = idCreator;
    }
}
