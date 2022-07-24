# How to Adapt android app for foldable devices  <!--  Title -->



<br>

## Introductions  <!-- Headline 1 -->

<p>
In 2019, Samsung introduced its first foldable smartphone, the <b>Samsung Galaxy Fold</b> which made headlines across the world. According to various global statistics sources, foldable smartphone screens will dominate in the near future. Over 75 million foldable smartphones will be produced by 2025. Developing applications for foldable smartphones will be the next challenge for developers.
</p>
<br>



## What are foldable devices?   <!-- Headline 2 -->

<p>
A phone with a particular display that can be folded in half is referred to as a foldable phone. Some devices fold vertically, some are horizontally. It can turn from a small device into bigger one. 
</p>
<br>


![](img/galaxy-fold.jpg?raw=true)

<p><b>
Figure 1: Galaxy Z Fold3
</b></p>
<br>




## Step to develop apps for foldable devices     <!--  Headline 3 -->

<p>
Foldable devices provide an opportunity for innovating app development. It provides both large and small screens on the same devices. They provide extra space, so developers can add more features on the app. 
</p>
<br>


<p>
* <b>Screen States:</b> Same device provides various states. Let’s have a look.
</p>
  

- **Folded State:** It looks like a standard smartphone that can be operated in one hand.

- **Open flat:** It looks like a tablet device. So developers can provide more functionality into the additional area. Users may need both hands in open flat condition. 

- **Open flat rotated to landscape:** It also opens flat with landscape mode. 

- **Half opened:** These states are between fully open and completely closed. 

  
<p>
Users may switch from one state to another. The app should restore its state when recreating the app layout on a folded or unfolded screen. For example:
</p>

- Retain text types into input fields

- Restore the keyboard state

- Restore the scroll position of scrollable fields

- Resume media playback where it left off when the app was stopped


<p>
So, developers have to make apps dynamic so that it overcomes different critical situations. Android introduced the FoldingFuture class so that developers can check various states of a folding device.
</p>
<br>

![](img/foldable_multiple_postures.png?raw=true)
  
<p><b>
Figure 2: Various states of foldable device
</b></p>
<br>



<p>
* <b>One or two handed app design:</b> The foldable devices bring huge changes of user experience. Users interact with phones with one hand. But, in the unfolded state, they may need to use both hands to interact. Thus, developers will need to adjust the placement of user interface elements accordingly for better user experience. 
</p>
<br>
  
  
  
<p>
* <b>Multi-window support:</b> One of the major advantages of a foldable device is users can get smartphone and tablet functionality with a single device. It has the ability to split a screen into two and run two apps on two different screens. The latest versions of Android allow users to open multiple apps alongside each other. Users might interact with a few multi-window apps and each app can be resizable. Just like apps on the desktop. So developers should keep it in mind when designing and developing the app for a foldable device.
</p>
<br>



<p>
* <b>Adjust the screen ratios:</b> In a foldable device, users might move from folded to unfolded state. In these situations, the app must resume its location and state. Developers may need to minimize the number of interface layout shifts, otherwise such shifts will interrupt the user experience.
</p>
<br>


<p>
* <b>Responsive design:</b> Responsive layouts enable an app to look great on various display sizes, like folded or unfolded screens. For example, a large-screen for foldable device unfolded in landscape is like a tablet, a two-pane layout with navigation rail makes it better. Then folded, the device is like a standard phone. Then  a single column layout with a bottom navigation bar is effective. 
</p>
<br>


![](img/fold-unfold.gif?raw=true)
  
<p><b>
Figure 3: Two types of design for folded and unfolded screen
</b></p>
<br>

<p>
* <b>Drag and drop:</b> Google introduced the Android Drag and Drop framework. Thus, developers can develop apps that enable drag and drop between  other apps. This will create a great user experience.
</p>
<br>





## Challenges of developing apps for foldable devices   <!--  Headline 4 -->

- **Quality & flexibility:** Foldable phones will come with multiple orientations, aspect ratios but what will remain the same is the quality expectations. The users will expect from developers  to deliver them error-free and high quality features for foldable devices.

- **Need more testing:** With a massive number of foldable phones soon to hit the smartphone market. So the app development team will have to work around a great number of test cases. 

- **Need more development time:** Developers will need to design and develop the app for a number of modes and multiple use cases. That’s why developing  apps for foldable phones is time consuming as a result, it costs more.

<br>




## Benefits of developing apps for the foldable devices     <!--  Headline 5 -->

- Foldable devices are the best option to play high quality videos having high resulutions.

- Lots of features and functionality can be added in comparison to regular smartphones.

- Due to the bigger screen size, developers are able to provide the detailed content.

- Due to the bigger screen size, app resizing is more smooth like desktop.

<p>
Targeting foldable device friendly apps can earn more revenue because of the rising popularity.
</p>
<br>




## Conclusions    <!--  Headline 6 -->

<p>
Foldable devices are a new invention in mobile technology. The foldable devices are becoming more popular and more demandable in the smartphone market, because of the attractive looking and portability.  The users can use it as a smartphone or as a tablet device.
</p>
<br>