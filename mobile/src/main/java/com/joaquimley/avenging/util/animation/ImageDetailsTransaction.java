package com.joaquimley.avenging.util.animation;

import android.annotation.TargetApi;
import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionSet;

/**
 * Transaction animation to the CharacterMarvel Image/Header on
 * {@link com.joaquimley.avenging.ui.character.CharacterActivity}
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class ImageDetailsTransaction extends TransitionSet {

    public ImageDetailsTransaction() {
        init();
    }

    private void init() {
        setOrdering(ORDERING_TOGETHER);
        addTransition(new ChangeBounds())
                .addTransition(new ChangeTransform())
                .addTransition(new ChangeImageTransform());
    }
}