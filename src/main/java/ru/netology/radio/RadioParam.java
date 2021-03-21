package ru.netology.radio;

public class RadioParam {

    public final static int FIRST_RADIO_WAVE = 0;
    public final static int LAST_RADIO_WAVE = 9;

    public final static int MAX_VOLUME = 10;
    public final static int MIN_VOLUME = 0;

    private int currentRadioWave = FIRST_RADIO_WAVE;
    private int currentVolume = MIN_VOLUME;

    public RadioParam() {

    }


    RadioParam(int currentRadioWave, int currentVolume) {
        this.currentRadioWave = currentRadioWave;
        this.currentVolume = currentVolume;
    }

    public int getCurrentRadioWave() {
        return currentRadioWave;
    }

    public void setCurrentRadioWave(int currentRadioWave) { //выбор радиостанции с пульта
        if (currentRadioWave < FIRST_RADIO_WAVE) {
            this.currentRadioWave = LAST_RADIO_WAVE;
        } else if (currentRadioWave > LAST_RADIO_WAVE) {
            this.currentRadioWave = FIRST_RADIO_WAVE;
        } else {
            this.currentRadioWave = currentRadioWave;
        }
    }

    public void chanelUp() {  //переключение на одну радиостанцию
        if (currentRadioWave < LAST_RADIO_WAVE) {
            currentRadioWave++;
        } else {
            currentRadioWave = FIRST_RADIO_WAVE;
        } //при переключении следующей волны за 9ой станцией кнопкой +
    }

    public void chanelDown() {
        if (currentRadioWave > FIRST_RADIO_WAVE) {
            currentRadioWave--;
        } else {
            currentRadioWave = LAST_RADIO_WAVE;
        }  //при переключении предыдущей волны перед 0ой станцией кнопкой -
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void volumeUp() { //увеличение громкости
        if (currentVolume < MAX_VOLUME) {
            currentVolume++;
        }
    }

    public void volumeDown() { //уменьшение громкости
        if (currentVolume > MIN_VOLUME) {
            currentVolume--;
        }
    }

}
