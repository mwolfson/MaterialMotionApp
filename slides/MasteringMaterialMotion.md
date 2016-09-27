build-lists: true
autoscale: true
footer: @mikewolfson
slidenumbers: true


## __Mastering Material Motion__
by Mike Wolfson
Droidcon NYC 2016

Download Demo App Now:
__*http://goo.gl/pq8VdA*__

---

![](https://material-design.storage.googleapis.com/publish/material_v_9/0Bx4BSt6jniD7VG9DQVluOFJ4Tnc/materialdesign_principles_metaphor.png)
![](https://material-design.storage.googleapis.com/publish/material_v_9/0Bx4BSt6jniD7NndTQW9VZTlZV2s/materialdesign_principles_bold.png)
![](https://material-design.storage.googleapis.com/publish/material_v_9/0Bx4BSt6jniD7dkRYelJkeklqWFU/materialdesign_principles_motion.png)

## __Material Design__

### **2014** - Material Design Guidelines
###     __*https://material.google.com*__
### **2016** - Motion Guidelines
###     __*https://material.google.com/motion*__

---

![](https://material-design.storage.googleapis.com/publish/material_v_9/0Bx4BSt6jniD7VG9DQVluOFJ4Tnc/materialdesign_principles_metaphor.png)
![](https://material-design.storage.googleapis.com/publish/material_v_9/0Bx4BSt6jniD7NndTQW9VZTlZV2s/materialdesign_principles_bold.png)
![](https://material-design.storage.googleapis.com/publish/material_v_9/0Bx4BSt6jniD7dkRYelJkeklqWFU/materialdesign_principles_motion.png)

## __Material Design Principles__

1. Material is the metaphor
1. Bold, graphic, intentional
1. Motion Provides Meaning

---

## __Motion Provides Meaning__

> "Key Giveaway of a High Quality App"
>
> "Makes Material, Material"
>
> "Most often overlooked part of making an App Great"



-- **John Schlemmer** *Motion Lead at Google*

![left](https://material-design.storage.googleapis.com/publish/material_v_9/0Bx4BSt6jniD7dkRYelJkeklqWFU/materialdesign_principles_motion.png)

---

## __Why do we need Motion Guidelines?__

- Describe works and what doesn't
- Pinpoint what feels "right"
- Avoid going overboard

![left](https://g-design.storage.googleapis.com/production/v6/assets/article/material-motion/renditions/breathe-1x1-620.jpg)

---

## __Motion Principles__

Material in motion has the following characteristics:

- Responsive
- Natural
- Aware
- Intentional

![left](https://g-design.storage.googleapis.com/production/v6/assets/article/material-motion/renditions/breathe-1x1-620.jpg)

---

## __Principle 1__
## Responsive

Motion respects and reinforces the user as the prime mover.

- Touch Feedback
- Elevation

![left 75%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/responsive.gif)

---

## __How to: Default Ripple__
### selectableItemBackground

```java
<TextView
        ...
        android:background="?attr/selectableItemBackground"
        />
```

Ripple without Border
__*?attr/selectableItemBackgroundBorderless*__

---

## __How to: Custom Ripple__

API 21+ can use RippleDrawable

1. Selector - support older OS
`res\drawable\bg_foo.xml`  

2. Ripple
`res\drawable-v21\bg_foo.xml`

3. Apply to View:

```JAVA
<TextView
        ...
        android:background="@drawable/bg_selector"/>
```

---

## __Custom Ripple XML__

```XML
<?xml version="1.0" encoding="utf-8"?>
<ripple xmlns:android="http://schemas.android.com/apk/res/android"
        android:color="@color/colorAccent">  <!-- Ripple Color -->

    <!--  Mask keeps Ripple within View bounds -->
    <color android:color="@android:color/white"/>
    <item android:id="@android:id/mask"/>
    <!--  Default Background Omit for none-->
    <item android:drawable="@color/grey_300"/>
</ripple>
```

---

## __Elevation: stateListAnimator__

1. Create Folder
`res\animator`

2. Create StateListAnimator
`res\animator\raise.xml`

3. Apply to View

```JAVA
<TextView
        ...
        `android:stateListAnimator="@animator/raise"`/>
```

__*https://blog.stylingandroid.com/statelistanimator/*__

---

## __StateListAnimator XML__

```XML
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_enabled="true" android:state_pressed="true">
        <objectAnimator
            android:duration="@android:integer/config_shortAnimTime"
            android:propertyName="translationZ"
            android:valueTo="8dp"
            android:valueType="floatType" />
    </item>
    <item>
        <objectAnimator
            android:duration="@android:integer/config_shortAnimTime"
            android:propertyName="translationZ"
            android:valueTo="0dp"
            android:valueType="floatType" />
    </item>
</selector>
```

---

## __How to: Custom Ripple with Elevation__

```java
<TextView
        ...
        android:background="@drawable/bg_selector"
        android:stateListAnimator="@animator/raise"/>
```


---

##__Principle  1__
### Responsive

Demo
*User generates energy in the form of ripple, and the material raising to the touch*

![left 75%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/responsive.gif)

---
## __Principle 2__
### Natural

Inspired by Reality

Material depicts natural movement inspired by forces in the real world.

- Duration
- Easing

![left 35%](/Users/mwolfson/Dropbox/Presentations/public/ball-1294662_1280.png)

---

## __Duration__
### Best Practices

- Keep it Fast (on all screens)
- Duration specific to screen size
- Natural Easing Curves
- Don't do it

^ Acceleration and deceleration changes should be smooth across the duration of an animation so that movement doesn't appear mechanical. Motion appears more natural and delightful when acceleration and deceleration occur asymmetrically.

---

## __Duration__
### Multiple screen sizes

Don't use single duration for all animations

- Tablet 130% `390ms`  
- Normal 100% `300ms`  
- Wearable 70% `210ms`

![left 95%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/multiScreenDuration.gif)

---

## __Easing Curves__

### Motion Duration and Easing Guidelines
###  __*https://material.google.com/motion/duration-easing.html*__

### Android Animation Interpolators
###  __*https://developer.android.com/reference/android/view/animation/Interpolator.html*__

### Chet Haase "Interpolator Playground"
###  __*https://github.com/google/android-ui-toolkit-demos/tree/master/Animations/InterpolatorPlayground*__

^ Use consistent and appropriate patterns for smooth Motion; Transitions on mobile typically occur over 300ms, within this margin of variance: Large, complex, full-screen transitions may have longer durations, occurring over 375ms    Objects entering the screen occur over 225ms    Objects leaving the screen occur over 195ms Transitions that exceed 400ms may feel too slow. Durations on tablet should be about 30% longer than on mobile. For example, a 300ms mobile duration would increase to 390ms on tablet.

---

## __Standard curve__

Objects quickly accelerate and slowly decelerate between on-screen locations.

Use **FastOutSlowInInterpolator**

![left 75%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/playgroundAccelDecel.gif)

^ This is the most common easing curve. Objects quickly accelerate and slowly decelerate between on-screen locations. It applies to growing and shrinking material, among other property changes.

---

## __Acceleration curve__
### (“Easing in”)

Objects leave the screen at full velocity. They do not decelerate when off-screen.

Use **FastOutLinearInInterpolator**

![left 75%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/playgroundAccelerate.gif)

^ During deceleration, objects may scale up either in size (to 100%) or opacity (to 100%). In some cases, when objects enter the screen at 0% opacity, they may slightly shrink from a larger size upon entry.

---

## __Deceleration curve__
### (“Easing out”)

Objects enter the screen at full velocity from off-screen and slowly decelerate to a resting point.

Use **LinearOutSlowInterpolator**

![left 75%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/playgroundDecelerate.gif)

^ During deceleration, objects may scale up either in size (to 100%) or opacity (to 100%). In some cases, when objects enter the screen at 0% opacity, they may slightly shrink from a larger size upon entry.

---

## __Principle 2__
### Natural

Demo

![left 75%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/natural.gif)

---

## __Bad - Don't specify Interpolator__
Default is **Linear**

```JAVA
exitBad.setOnClickListener(new View.OnClickListener() {
    // BAD- no interpolator, will default to Linear
    public void onClick(View view) {        
        Animation anim3 = AnimationUtils.loadAnimation(mActivity,
        R.anim.slideup_in);
        bigRedBall.startAnimation(anim3); }
});
```

---

## __Good - Use correct Interpolator__
For **exit** animation

```JAVA
exitGood.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view) {
        Animation anim1 = AnimationUtils.loadAnimation(mActivity, R.anim.slideup_in);
        Interpolator interpFosi = AnimationUtils.loadInterpolator(mActivity,
        android.R.interpolator.fast_out_slow_in);
        anim1.setInterpolator(interpFosi);
        bigRedBall.startAnimation(anim1); }
});
```

---

## __Good - Use correct Interpolator__
For **enter** animation

```JAVA
enterGood.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view) {
        Animation anim2 = AnimationUtils.loadAnimation(mActivity, R.anim.slidedown_out);        
        Interpolator interpFoli = AnimationUtils.loadInterpolator(mActivity,
        android.R.interpolator.fast_out_linear_in);
        anim2.setInterpolator(interpFoli);
        bigRedBall.startAnimation(anim2); }
});
```

---

## __Principle 3__
### Aware

Material is aware of its surroundings, including the user and other material around it. It can be attracted to objects and respond appropriately to user intent.

![left 75%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/aware.gif)

---

## __Automatic animation__

Layout on right has following attribute:

```java
<LinearLayout
    ...
    android:animateLayoutChanges="true" >
```


![left 75%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/aware.gif)

---

## __RecyclerView__
Use adapter methods

####  - notifyItemInserted(2)
####  - notifyItemRangeChanged(2, 6)
####  - notifyItemRemoved(2)
####  - __*https://developer.android.com/reference/android/support/v7/util/DiffUtil.html*__




---

## __Principle 4__
### Intentional

Material in motion guides focus to the right spot at the right time.

![left 80%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/intentionalGood.gif)

^this is a great article https://github.com/codepath/android_guides/wiki/Shared-Element-Activity-Transition

---

## __Intentional__
### Single Element

One item moves

![left 75%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/intentional1.gif)

---

## __Intentional__
### Two Elements

**Good**
Two items move together

![left 75%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/intentional2.gif)

---

## __Intentional__
### Too many elements

**Bad**
Two items move differently

![left 75%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/intentional3.gif)

---

## __Intentional__
### Too many elements

**Really, Really Bad**
*Normal speed*

![left 75%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/intentional4.gif)

---

## __Intentional__
### Too many elements

Demo - slowed down
*33% of normal speed*

![left 80%](/Users/mwolfson/Dropbox/Presentations/Movies/GIFs/intentionalBadSlow.gif)

---

## __How to: SharedElementTransition__
### 1. Enable transitions in base *styles.xml*

```xml
<!-- Base application theme. -->
<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
    <!-- Customize your theme here. -->
    <item name="android:windowContentTransitions">true</item>
    ...
</style>
```

---

## __How to: SharedElementTransition__
### 2. Transition Attribute in *Start* and *End* layouts

```JAVA
//Activity #1
<ImageView
        android:id="@+id/hero_img1"
        ...
        android:transitionName="@string/trans_hero1" />
//Activity #2
<ImageView
        android:id="@+id/hero_img1_lg"
        ...
        android:transitionName="@string/trans_hero1" />
```

---

## __How to: SharedElementTransition__
### 3. Call transition in Java

```java
final ImageView heroImg1 = (ImageView) findViewById(R.id.hero_img1);
final String transHero = getResources().getString(R.string.trans_hero1);
heroImg1.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         Intent intent = new Intent(mActivity, IntentionalEndActivity.class);

         ActivityOptionsCompat options = ActivityOptionsCompat.
                 makeSceneTransitionAnimation(mActivity, (View)heroImg1, transHero);

         startActivity(intent, options.toBundle());
     }
 });
```

---

## __Review: Motion Principles__

Material in motion has the following characteristics:

- Responsive
- Natural
- Aware
- Intentional

![left](https://g-design.storage.googleapis.com/production/v6/assets/article/material-motion/renditions/breathe-1x1-620.jpg)

---

## __Thank You__
### Resources

http://android-developers.blogspot.com/2014/10/implementing-material-design-in-your.html

http://www.mikewolfson.com

http://goo.gl/pq8VdA

https://github.com/mwolfson/MaterialMotionApp

---

## Review

### _**Style 1**_
### __*Style 2*__
- __**Style 3**__
