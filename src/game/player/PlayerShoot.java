package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import input.KeyboardInput;
import utils.Utils;

import javax.sound.sampled.Clip;

public class PlayerShoot {
    private FrameCounter frameCounter;
    public Shoot shoot;
    public SingleShoot singleShoot;
    public TripleShoot tripleShoot;
    private Clip clip;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(20);
        this.tripleShoot = new TripleShoot();
        this.shoot = this.tripleShoot;
        this.clip = Utils.loadAudio("resources/audio/shot.wav");
    }

    public void run(Player player) {
        if (KeyboardInput.instance.spacePressed) {
            this.shoot.shoot(player);
            this.clip.loop(1);
            this.clip.start();
            if (this.frameCounter.run()) {

                this.frameCounter.reset();
            }
        }

    }
}
