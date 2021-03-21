package ru.netology.radio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioParamTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void radioWaveInLimit(int wave) {       // переключение станции с пульта в диапазоне от 0 до 9
        RadioParam radioParam = new RadioParam();
        radioParam.setCurrentRadioWave(wave);

        int actual = radioParam.getCurrentRadioWave();

        assertEquals(wave, actual, radioParam.getCurrentRadioWave());
    }

    @Test
    public void radioWaveOverLimit() {       // ввод 10ой станции с пульта
        RadioParam radioParam = new RadioParam();
        int newWave = 10;
        int expected = RadioParam.FIRST_RADIO_WAVE;

        radioParam.setCurrentRadioWave(newWave);
        assertEquals(expected, radioParam.getCurrentRadioWave());
    }

    @Test
    public void radioWaveUnderLimit() {       // ввод -10й станции с пульта
        RadioParam radioParam = new RadioParam();
        int expected = RadioParam.LAST_RADIO_WAVE;
        int newWave = -1;

        radioParam.setCurrentRadioWave(newWave);
        assertEquals(expected, radioParam.getCurrentRadioWave());
    }

    @Test
    public void waveInLimit() {       //переключение станции кнопкой от 0 до 9
        RadioParam radioParam = new RadioParam();

        for (int i = RadioParam.FIRST_RADIO_WAVE; i <= RadioParam.LAST_RADIO_WAVE; i++) {
            assertEquals(i, radioParam.getCurrentRadioWave());
            radioParam.chanelUp();
        }
    }

    @Test
    public void waveInLimitReverse() {       // переключение станции кнопкой с 9 до 0
        RadioParam radioParam = new RadioParam(RadioParam.LAST_RADIO_WAVE, RadioParam.MIN_VOLUME);

        for (int i = RadioParam.LAST_RADIO_WAVE; i >= RadioParam.FIRST_RADIO_WAVE; i--) {
            assertEquals(i, radioParam.getCurrentRadioWave());
            radioParam.chanelDown();
        }
    }

    @Test
    public void waveOverLimit() {       //переключение станции кнопкой с 9 на 10
        RadioParam radioParam = new RadioParam(RadioParam.LAST_RADIO_WAVE, RadioParam.MIN_VOLUME);

        radioParam.chanelUp();
        int expected = RadioParam.FIRST_RADIO_WAVE;
        assertEquals(expected, radioParam.getCurrentRadioWave());
    }

    @Test
    public void waveUnderLimit() {       //переключение станции кнопкой с 0 на -1
        RadioParam radioParam = new RadioParam();

        radioParam.chanelDown();
        int expected = RadioParam.LAST_RADIO_WAVE;
        assertEquals(expected, radioParam.getCurrentRadioWave());
    }

    @Test
    public void volumeInLimit() {       // переключение звука от 0 на 10
        RadioParam radioParam = new RadioParam();

        for (int i = RadioParam.MIN_VOLUME; i <= RadioParam.MAX_VOLUME; i++) {
            assertEquals(i, radioParam.getCurrentVolume());
            radioParam.volumeUp();
        }
    }

    @Test
    public void volumeInLimitReverse() {       // переключение звука с 10 до 0
        RadioParam radioParam = new RadioParam(RadioParam.FIRST_RADIO_WAVE, RadioParam.MAX_VOLUME);

        for (int i = RadioParam.MAX_VOLUME; i >= RadioParam.MIN_VOLUME; i--) {
            assertEquals(i, radioParam.getCurrentVolume());
            radioParam.volumeDown();
        }
    }

    @Test
    public void volumeOverLimit() {       //переключение звука с 10 на 11
        RadioParam radioParam = new RadioParam(RadioParam.MIN_VOLUME, RadioParam.MAX_VOLUME);

        radioParam.volumeUp();
        int expected = RadioParam.MAX_VOLUME;
        assertEquals(expected, radioParam.getCurrentVolume());
    }

    @Test
    public void volumeUnderLimit() {       //переключение звука с 0 на -1
        RadioParam radioParam = new RadioParam();

        radioParam.volumeDown();
        int expected = RadioParam.MIN_VOLUME;
        assertEquals(expected, radioParam.getCurrentVolume());
    }
}