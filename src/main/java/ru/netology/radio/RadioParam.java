package ru.netology.radio;

public class RadioParam {

    private final static int FIRST_RADIO_WAVE = 0;
    private final static int LAST_RADIO_WAVE = 9;

    private final static int MAX_VOLUME = 10;
    private final static int MIN_VOLUME = 0;

    private int currentRadioWave;
    private int currentVolume;


    public int getCurrentRadioWave() {
        return currentRadioWave;
    }

    public void setCurrentRadioWave(int currentRadioWave) {
        if (currentRadioWave >= FIRST_RADIO_WAVE) {
            if (currentRadioWave <= LAST_RADIO_WAVE) {
                this.currentRadioWave = currentRadioWave; //при значении текущей станции между 0 и 9
            }
        }
        if (currentRadioWave > LAST_RADIO_WAVE) {
            this.currentRadioWave = FIRST_RADIO_WAVE; //при переключении следующей волны за 9ой станцией
        }
        if (currentRadioWave < FIRST_RADIO_WAVE) {
            this.currentRadioWave = LAST_RADIO_WAVE; //при переключении предыдущей волны перед 0ой станцией
        }
    }


    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume >= MIN_VOLUME) {
            if (currentVolume <= MAX_VOLUME) {
                this.currentVolume = currentVolume; //при значении текущей громкости между 0 и 10
            }
        }
        if (currentVolume > MAX_VOLUME) {
            this.currentVolume = MAX_VOLUME; //при переключении громкости выше максимальной
        }
        if (currentVolume < MIN_VOLUME) {
            this.currentVolume = MIN_VOLUME; //при переключении громкости ниже минимальной

        }
    }

}
