<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Starter page</title>
    <style>


.button--piyo{
    --main_color : #f4cf47 ;
    --sub_color1 : #f4e19c ;
    --sub_color2 : #ff8108 ;
    --base_color : #000 ;
    --border_radius1 : 60px 60px 40px 40px / 48px 48px 30px 30px ;
    --border_radius2 : 70px 70px 40px 40px / 48px 48px 30px 30px ;
    --border_radius3 : 40px 40px 40px 40px / 48px 48px 30px 30px ;
}
.button--hoo{
    --main_color : #4993ff ;
    --sub_color1 : #385082 ;
    --sub_color2 : #fff58f ;
    --sub_color3 : #fff ;
    --base_color : #FFF ;
    --border_radius1 : 50px 50px 50px 50px / 40px 40px 40px 40px ;
    --border_radius2 : 60px 60px 50px 50px / 40px 40px 40px 40px ;
    --border_radius3 : 40px 40px 50px 50px / 60px 60px 40px 40px ;
    --border_radius3 : 50px 50px 45px 45px / 40px 40px 60px 60px ;
}
.button--pen{
    --main_color : #4d4d4d ;
    --sub_color1 : #FFF ;
    --sub_color2 : #e9b800 ;
    --base_color : #e9b800 ;
    --border_radius1 : 60px 60px 40px 40px / 48px 48px 30px 30px ;
    --border_radius2 : 70px 70px 40px 40px / 48px 48px 30px 30px ;
    --border_radius3 : 40px 40px 40px 40px / 48px 48px 30px 30px ;
}
.button{
    position : relative ;
    display : flex ;
    justify-content : center ;
    align-items : center ;
    width : 280px ;
    height : 80px ;
    box-sizing : border-box ;
    text-decoration : none ;
    border : solid 3px #000 ;
    border-radius : 40px ;
    background : var(--main_color) ;
    font-family: 'Fredoka One', cursive;
}
.button::before{
    content : '' ;
    position : absolute ;
    z-index : 2 ;
    top : 0 ;
    right : 20px ;
    bottom : 0 ;
    margin : auto 0 ;
    width : 24px ;
    height : 24px ;
    background : var(--base_color) ;
    transition : all ease .2s ;
}
.button__wrapper{
    display : flex ;
    justify-content : center ;
    align-items : center ;
    position : relative ;
    z-index : 1 ;
    width : 100% ;
    height : 100% ;
    border-radius : 40px ;
    overflow : hidden ;
}
.button__wrapper::before,
.button__wrapper::after{
    transition : all .5s ease ;
}
.characterBox{
    position : absolute ;
    top : -54px ;
    left : 0 ;
    right : 0 ;
    margin : 0 auto ;
    display : flex ;
    justify-content : space-between ;
    align-items : flex-end ;
    width : 180px ;
    height : 56px ;
}
.button__text{
    position : relative ;
    z-index : 3 ;
    font-size : 32px ;
    letter-spacing : 4px ;
    color : var(--base_color) ;
    transition : all .3s ease ;
}
.character{
    position : relative ;
    width : 56px ;
    height : 36px ;
    box-sizing : border-box ;
    border : solid 3px #000 ;
    background : var(--main_color) ;
    border-radius : var(--border_radius1) ;
    animation : sleep 1s ease infinite alternate ;
}
.character::before{
    content : '' ;
    position : absolute ;
    top : -12px ;
    left : 22px ;
    width : 12px ;
    height : 12px ;
    background : #000 ;
    clip-path : path('M10.23,3.32c-3.54,.63-5.72,2.51-7.02,4.23-.33-1.58-.34-3.54,.93-5.12,.52-.65,.41-1.59-.24-2.11C3.24-.19,2.29-.08,1.77,.57c-3.82,4.77-.31,11.11-.13,11.42,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0-.01-.02,2.49,.04,2.52,0,.1-.14,1.54-4.82,6.59-5.71,.82-.14,1.37-.92,1.22-1.74s-.94-1.36-1.75-1.21Z') ;
}
.character__face{
    position : absolute ;
    z-index : 2 ;
    top : 15px ;
    left : 0 ;
    right : 0 ;
    margin : 0 auto ;
    width : 12px ;
    height : 6px ;
    background : var(--sub_color2) ;
    border-radius : 50% 50% 50% 50% / 78% 78% 22% 22% ;
    transition : .2s ;
}
.character__face::before,
.character__face::after{
    content : '' ;
    position : absolute ;
    top : -4px ;
    width : 8px ;
    height : 2px ;
    border-radius : 4px ;
    background : #000 ;
}
.character__face::before{
    left : -5px ;
}
.character__face::after{
    right : -5px ;
}
.button--hoo .character__face::before,
.button--hoo .character__face::after{
    background : #fff ;
}
.button--hoo .charactor__face2{
    position : absolute ;
    z-index : 1 ;
    top : 8px ;
    left : 0 ;
    right : 0 ;
    margin : auto ;
    width : 14px ;
    height : 10px ;
    background : #385082 ;
    animation : face_hoo 1s ease infinite alternate ;
}
.button--hoo .charactor__face2::before,
.button--hoo .charactor__face2::after{
    content : '' ;
    position : absolute ;
    top : -1px ;
    width : 20px ;
    height : 10px ;
    box-sizing : border-box ;
    border-radius : 50% ;
    border : solid 3px #385082 ;
    background : #000 ;
}
.button--hoo .charactor__face2::before{
    left : -12px ;
}
.button--hoo .charactor__face2::after{
    right : -12px ;
}
.button--hoo .charactor__body{
    position : absolute ;
    bottom : 0 ;
    left : 0 ;
    right : 0 ;
    margin : 0 auto ;
    width : 0 ;
    height : 0 ;
    border-top : solid 2px #385082 ;
    border-left : solid 7px transparent ;
    border-right : solid 7px transparent ;
    border-bottom : solid 0 transparent ;
    animation : body_hoo 1s ease infinite alternate ;
}
.button--hoo .charactor__body::before,
.button--hoo .charactor__body::after{
    content : '' ;
    position : absolute ;
    top : -4px ;
    width : 0 ;
    height : 0 ;
    border-top : solid 2px #385082 ;
    border-left : solid 7px transparent ;
    border-right : solid 7px transparent ;
    border-bottom : solid 0 transparent ;
}
.button--hoo .charactor__body::before{
    left : -17px ;
}
.button--hoo .charactor__body::after{
    right : -17px ;
}

.button--pen .charactor__face2{
    position : absolute ;
    z-index : 1 ;
    bottom : 0 ;
    left : 0 ;
    right : 0 ;
    margin : auto ;
    width : 30px ;
    height : 10px ;
    border-radius : 50% ;
    background : #fff ;
    animation : face_pen 1s ease infinite alternate ;
}
.button--pen .charactor__face2::before,
.button--pen .charactor__face2::after{
    content : '' ;
    position : absolute ;
    top : -8px ;
    width : 17px ;
    height : 10px ;
    border-radius : 50% ;
    background : #fff ;
}
.button--pen .charactor__face2::before{
    left : -4px ;
}
.button--pen .charactor__face2::after{
    right : -4px ;
}

.button--piyo::before{
    clip-path : path('M24,12.02c0-1.09-.75-1.71-.81-1.77L11.17,.45c-.91-.74-2.21-.56-2.91,.42-.69,.97-.52,2.37,.39,3.11l7.12,5.81-13.7-.02h0C.93,9.77,0,10.76,0,11.99c0,1.23,.93,2.22,2.07,2.22l13.7,.02-7.13,5.78c-.91,.74-1.09,2.13-.4,3.11,.41,.58,1.03,.88,1.65,.88,.44,0,.88-.15,1.25-.45l12.04-9.76c.07-.06,.82-.67,.82-1.77Z') ;
}
.button--hoo::before{
    clip-path : path('M21.93,9.8h-3.33S11.5,.79,11.5,.79c-.74-.94-2.05-1.05-2.92-.26-.88,.79-.99,2.19-.25,3.13l4.84,6.13-11.09-.02C.95,9.73,0,10.76,0,11.99c0,1.23,.93,2.22,2.07,2.22l11.09,.02-4.86,6.12c-.74,.93-.63,2.33,.24,3.13,.39,.35,.87,.53,1.34,.53,.59,0,1.17-.27,1.58-.78l7.13-8.99h3.32s0,0,0,0c1.14,0,2.07-.99,2.07-2.22,0-1.23-.93-2.22-2.07-2.22Z') ;
}
.button--pen::before{
    clip-path : path('M23.36,10.63L6.18,.13c-.93-.57-1.85,.81-1.39,2.06l1.44,3.91c.3,.81,.01,1.81-.6,2.1L.72,10.58c-.96,.47-.96,2.37,0,2.83l4.91,2.38c.62,.3,.9,1.29,.6,2.1l-1.44,3.91c-.46,1.26,.46,2.63,1.39,2.06L23.36,13.37c.86-.53,.86-2.22,0-2.75Z') ;
}
.button--piyo .button__wrapper::before,
.button--piyo .button__wrapper::after{
    content : '' ;
    position : absolute ;
    bottom : 0 ;
    width : 130px ;
    height : 38px ;
    background : var(--sub_color1) ;
    clip-path : path('M13.77,37.35L.25,16.6c-.87-1.33,.69-2.91,2-2.02l12.67,8.59c.81,.55,1.91,.14,2.18-.81l2.62-9.33c.39-1.4,2.34-1.42,2.76-.02l3.6,11.99c.33,1.11,1.74,1.4,2.47,.52L49.38,.52c.87-1.04,2.53-.42,2.53,.95V23.7c0,1.13,1.2,1.83,2.16,1.26l12.75-7.51c.85-.5,1.94,0,2.13,.98l1.5,7.6c.2,1.03,1.37,1.51,2.22,.92l17.74-12.3c1.09-.75,2.52,.25,2.21,1.55l-2.44,10.2c-.26,1.09,.74,2.06,1.8,1.75l30.8-9.04c1.37-.4,2.42,1.26,1.49,2.36l-9.07,10.66c-.83,.98-.1,2.49,1.17,2.42l12.12-.68c1.6-.09,2.12,2.15,.65,2.8l-2.73,1.21c-.18,.08-.38,.12-.58,.12H14.97c-.48,0-.93-.25-1.2-.65Z') ;
}
.button--piyo .button__wrapper::before{
    left : 0 ;
}
.button--piyo .button__wrapper::after{
    right : 0 ;
    transform : rotateY(180deg) ;
}
.button--hoo .button__wrapper::before,
.button--hoo .button__wrapper::after{
    content : '' ;
    position : absolute ;
    width : 80px ;
    height : 100px ;
    background : var(--sub_color1) ;
    clip-path : path('M75.96,41.27l-42.76,11.17V0H0V100H33.2v-28.75l45.07-23.97c3.38-1.8,1.39-6.98-2.31-6.01Z') ;
}
.button--hoo .button__wrapper::before{
    left : 6px ;
    bottom : 0 ;
}
.button--hoo .button__wrapper::after{
    right : 8px ;
    bottom : -10px ;
    transform : rotateY(180deg) ;
}
.button--pen .button__wrapper::before,
.button--pen .button__wrapper::after{
    content : '' ;
    position : absolute ;
    width : 110px ;
    height : 60px ;
    background : var(--sub_color1) ;
    clip-path : path('M9.12,14.14L43.15,.5c1.61-.86,3.57-.59,4.9,.68l19.55,14.31c.42,.4,.76,.89,.99,1.42l3.45,13.09c.89,2.06,3.18,3.09,5.28,2.37l11.76-4.86c1.56-.54,3.29-.11,4.43,1.1l11.93,12.39c.48,.51,.84,1.12,1.03,1.8l3.35,11.62c.8,2.79-1.25,5.58-4.1,5.58H4.27c-2.71,0-4.73-2.54-4.18-5.24L6.92,17.11c.26-1.28,1.07-2.37,2.2-2.97Z') ;
}
.button--pen .button__wrapper::before{
    left : -16px ;
    bottom : -10px ;
}
.button--pen .button__wrapper::after{
    right : -8px ;
    bottom : -20px ;
    transform : rotateY(180deg) ;
}
.button:hover .button__wrapper::before{
    transform : translateX(-12px) ;
}
.button:hover .button__wrapper::after{
    transform : rotateY(180deg) translateX(-12px) ;
}
.button:hover .button__text{
    letter-spacing : 6px ;
}
.button:hover::before{
    right : 14px ;
}
.button:hover .wakeup{
    animation : wakeup .2s ease ;
    animation-fill-mode : forwards ;
}
.button:hover .wakeup .character__face{
    top : 20px ;
}
.button:hover .wakeup .character__face::before,
.button:hover .wakeup .character__face::after{
    animation : eye 5s linear infinite ;
}
.button:hover .wakeup:nth-child(2) .character__face::before,
.button:hover .wakeup:nth-child(2) .character__face::after{
    animation : eye_2 5s linear infinite ;
}
.button--hoo:hover .wakeup .charactor__face2::before,
.button--hoo:hover .wakeup .charactor__face2::after{
    height : 20px ;
}
.button--hoo:hover .wakeup .charactor__body{
    animation : body_hoo_wakeup .2s ease ;
    animation-fill-mode : forwards ;
    border-top : solid 6px #385082 ;
}
.button--hoo:hover .wakeup .charactor__body::before,
.button--hoo:hover .wakeup .charactor__body::after{
    top : -12px ;
    border-top : solid 5px #385082 ;
}
.button--pen:hover .wakeup .charactor__face2{
    animation : face_pen_wakeup .2s ease ;
    animation-fill-mode : forwards ;
}
.button--pen:hover .wakeup .charactor__face2::before,
.button--pen:hover .wakeup .charactor__face2::after{
    top : -12px ;
    height : 18px ;
}
@keyframes sleep{
    0%  {
        height : 36px ;
        border-radius : var(--border_radius1) ;
    }
    100%{
        height : 32px ;
        border-radius : var(--border_radius2) ;
    }
}
@keyframes wakeup{
    0%  {
        height : 32px ;
        border-radius : var(--border_radius2) ;
    }
    100%{
        height : 56px ;
        border-radius : var(--border_radius3) ;
    }
}
@keyframes eye {
    0%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
    }
    30%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
    }
    32%{
        top : -4px ;
        width : 8px ;
        height : 2px ;
    }
    34%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
    }
    70%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
    }
    72%{
        top : -4px ;
        width : 8px ;
        height : 2px ;
    }
    74%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
    }
    76%{
        top : -4px ;
        width : 8px ;
        height : 2px ;
    }
    78%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
    }
    100%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
    }
}
@keyframes eye_2 {
    0%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
    }
    10%{
        transform : translateX(0);
    }
    12%{
        transform : translateX(3px);
    }
    20%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
    }
    22%{
        top : -4px ;
        width : 8px ;
        height : 2px ;
    }
    24%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
    }
    25%{
        transform : translateX(3px);
    }
    27%{
        transform : translateX(0);
    }
    74%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
        transform : translateX(0);
    }
    76%{
        top : -4px ;
        width : 8px ;
        height : 2px ;
        transform : translateX(3px);
    }
    78%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
    }
    80%{
        top : -4px ;
        width : 8px ;
        height : 2px ;
    }
    82%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
    }
    85%{
        transform : translateX(3px);
    }
    87%{
        transform : translateX(0);
    }
    100%{
        top : -6px ;
        width : 6px ;
        height : 6px ;
        transform : translateX(0);
    }
}
@keyframes body_hoo{
    0%  {
        bottom : 2px ;
    }
    100%{
        bottom : 0 ;
    }
}
@keyframes body_hoo_wakeup{
    0%  {
        bottom : 2px ;
    }
    100%{
        bottom : 6px ;
    }
}
@keyframes face_pen{
    0%  {
        height : 14px ;
    }
    100%{
        height : 10px ;
    }
}
@keyframes face_pen_wakeup{
    0%  {
        height : 14px ;
    }
    100%{
        height : 28px ;
    }
}
.container{
    width : 100% ;
    height : 600px ;
    display : flex ;
    flex-direction : column ;
    justify-content : center ;
    align-items : center ;
    background : #FFF ;
    margin-top: 110px;
}
.button:not(:last-child){
    margin-bottom : 80px ;
}

</style>
</head>
<body>
<div class="container">
    <a href="#" class="button button--piyo">
        <div class="button__wrapper">
            <button class="button__text" onclick="window.location='/lab4/task1/index.jsp'" type="button">Task 1</button>
        </div>
        <div class="characterBox">
            <div class="character wakeup">
                <div class="character__face"></div>
            </div>
            <div class="character wakeup">
                <div class="character__face"></div>
            </div>
            <div class="character">
                <div class="character__face"></div>
            </div>
        </div>
    </a>

    <a href="#" class="button button--hoo">s
        <div class="button__wrapper">
            <button class="button__text" onclick="window.location='/lab4/task2/index.jsp'" type="button">Task 2</button>
        </div>
        <div class="characterBox">
            <div class="character wakeup">
                <div class="character__face"></div>
                <div class="charactor__face2"></div>
                <div class="charactor__body"></div>
            </div>
            <div class="character wakeup">
                <div class="character__face"></div>
                <div class="charactor__face2"></div>
                <div class="charactor__body"></div>
            </div>
            <div class="character">
                <div class="character__face"></div>
                <div class="charactor__face2"></div>
                <div class="charactor__body"></div>
            </div>
        </div>
    </a>

    <a href="#" class="button button--pen">
        <div class="button__wrapper">
            <button class="button__text" onclick="window.location='/lab4/task3/lib.jsp'" type="button">Task 3</button>
        </div>
        <div class="characterBox">
            <div class="character wakeup">
                <div class="character__face"></div>
                <div class="charactor__face2"></div>
            </div>
            <div class="character wakeup">
                <div class="character__face"></div>
                <div class="charactor__face2"></div>
            </div>
            <div class="character">
                <div class="character__face"></div>
                <div class="charactor__face2"></div>
            </div>
        </div>
    </a>

    <a href="#" class="button button--piyo">
            <div class="button__wrapper">
                <button class="button__text" onclick="window.location='/lab4/task4/index.jsp'" type="button">Task 4</button>
            </div>
            <div class="characterBox">
                <div class="character wakeup">
                    <div class="character__face"></div>
                    <div class="charactor__face2"></div>
                </div>
                <div class="character wakeup">
                    <div class="character__face"></div>
                    <div class="charactor__face2"></div>
                </div>
                <div class="character">
                    <div class="character__face"></div>
                    <div class="charactor__face2"></div>
                </div>
            </div>
        </a>

        <a href="#" class="button button--hoo">
                <div class="button__wrapper">
                    <button class="button__text" onclick="window.location='/lab4/task5/index.jsp'" type="button">Task 5</button>
                </div>
                <div class="characterBox">
                    <div class="character wakeup">
                        <div class="character__face"></div>
                        <div class="charactor__face2"></div>
                        <div class="charactor__body"></div>
                    </div>
                    <div class="character wakeup">
                        <div class="character__face"></div>
                        <div class="charactor__face2"></div>
                        <div class="charactor__body"></div>
                    </div>
                    <div class="character">
                        <div class="character__face"></div>
                        <div class="charactor__face2"></div>
                        <div class="charactor__body"></div>
                    </div>
                </div>
            </a>

</div>
</body>
</html>
