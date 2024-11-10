import processing.core.PApplet;

import static parameters.Parameters.*;
import static save.SaveUtil.saveSketch;

public class FoldingSpace extends PApplet {
    public static void main(String[] args) {
        PApplet.main(FoldingSpace.class);
    }

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
        randomSeed(SEED);
        noiseSeed(floor(random(MAX_INT)));
    }

    @Override
    public void setup() {
        background(BACKGROUND_COLOR.red(), BACKGROUND_COLOR.green(), BACKGROUND_COLOR.blue());
        stroke(STROKE_COLOR.red(), STROKE_COLOR.green(), STROKE_COLOR.blue(), STROKE_COLOR.alpha());
        noFill();
        noLoop();
    }

    @Override
    public void draw() {
        for (int k = 0; k < NUMBER_OF_POINTS; k++) {
            float a = random(TWO_PI), b = random(TWO_PI);
            point(constrain(NOISE_ZOOM
                                    * sq(noise(NOISE_SCALE * cos(a),
                                    NOISE_SCALE * sin(a))),
                            0,
                            1)
                            * width,
                    constrain(NOISE_ZOOM
                                    * sq(noise(NOISE_SCALE * cos(b),
                                    NOISE_SCALE * sin(b),
                                    cos(a) * NOISE_SCALE)),
                            0,
                            1)
                            * height);
        }
        saveSketch(this);
    }
}
