package ru.netology.radio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioParamTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void radioWaveInLimit(int wave) {       //станция в пределе от 0 до 9
        RadioParam radioParam = new RadioParam();
        radioParam.setCurrentRadioWave(wave);

        int actual = radioParam.getCurrentRadioWave();

        assertEquals(wave, actual, radioParam.getCurrentRadioWave());
    }

    @Test
    public void radioWaveOverLimit() {       //переключение станции с 9 на 0
        RadioParam radioParam = new RadioParam();
        int newWave = 10;
        int expected = 0;

        radioParam.setCurrentRadioWave(newWave);
        assertEquals(expected, radioParam.getCurrentRadioWave());
    }

    @Test
    public void radioWaveUnderLimit() {       //переключение станции с 0 на 9
        RadioParam radioParam = new RadioParam();
        int expected = 9;
        int newWave = -1;

        radioParam.setCurrentRadioWave(newWave);
        assertEquals(expected, radioParam.getCurrentRadioWave());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void volumeInLimit(int volume) {       //переключение звука от 0 на 10
        RadioParam radioParam = new RadioParam();


        radioParam.setCurrentVolume(volume);
        assertEquals(volume, radioParam.getCurrentVolume());
    }

    @Test
    public void volumeOverLimit() {       //переключение звука с 10 на 11
        RadioParam radioParam = new RadioParam();
        int expected = 10;
        int newVolume = 11;

        radioParam.setCurrentVolume(newVolume);
        assertEquals(expected, radioParam.getCurrentVolume());
    }

    @Test
    public void volumeUnderLimit() {       //переключение звука с 0 на -1
        RadioParam radioParam = new RadioParam();
        int expected = 0;
        int newVolume = -1;

        radioParam.setCurrentVolume(newVolume);
        assertEquals(expected, radioParam.getCurrentVolume());
    }
}