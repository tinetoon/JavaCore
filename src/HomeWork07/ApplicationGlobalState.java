package HomeWork07;

/**
 * Класс состояний приложения
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 09.10.2021
 */

public final class ApplicationGlobalState {

    private static ApplicationGlobalState INSTANCE;
    private String selectedCity = null;
    private final String APPI_ID = "7063829f1fd4a64b42f6787514262064";

    private ApplicationGlobalState() {
    }

    // Непотокобезопасный код для упрощения
    public static ApplicationGlobalState getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }
        return INSTANCE;
    }

    // Геттеры
    public String getSelectedCity() {
        return selectedCity;
    }
    public String getAPPI_ID() {
        return APPI_ID;
    }

    // Сеттер
    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }
}