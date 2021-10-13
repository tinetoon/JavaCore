package HomeWork07;

/**
 * Класс состояний приложения
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 09.10.2021
 */

public final class ApplicationGlobalState {

    private static ApplicationGlobalState INSTANCE;
    private String selectedCityZip = null;
    private String selectedPeriod = null;
    private final String APPI_ID_OW = "7063829f1fd4a64b42f6787514262064"; // API_ID (!!! создан в учебных целях, возможно потребуется замена)

    private ApplicationGlobalState() {
    }

    // Непотокобезопасный код для упрощения (!!! взят из кода с лекции, разобраться с логикой)
    public static ApplicationGlobalState getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }
        return INSTANCE;
    }

    // Геттеры
    public String getSelectedCityZip() {
        return selectedCityZip;
    }
    public String getSelectedPeriod() {
        return selectedPeriod;
    }
    public String getAPPI_ID_OW() {
        return APPI_ID_OW;
    }

    // Сеттеры
    public void setSelectedCity(String selectedCity) {
        this.selectedCityZip = selectedCity;
    }
    public void setSelectedPeriod(String selectedPeriod) {
        this.selectedPeriod = selectedPeriod;
    }
}