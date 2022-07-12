<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Tinder | Meet New People Profiles</title>

    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/styles.css">
    <link href="/assets/css/cover.css" rel="stylesheet">

    <style>
        .bg {
            background-image: url("assets/img/tinder_cover.jpeg");
            height: 100%;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }

        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .b-example-divider {
            height: 3rem;
            background-color: rgba(0, 0, 0, .1);
            border: solid rgba(0, 0, 0, .15);
            border-width: 1px 0;
            box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
        }

        .b-example-vr {
            flex-shrink: 0;
            width: 1.5rem;
            height: 100vh;
        }

        .bi {
            vertical-align: -.125em;
            fill: currentColor;
        }

        .nav-scroller {
            position: relative;
            z-index: 2;
            height: 2.75rem;
            overflow-y: hidden;
        }

        .nav-scroller .nav {
            display: flex;
            flex-wrap: nowrap;
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }
    </style>
</head>

<body class="d-flex h-100 text-center text-white bg-dark">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">

    <header class="mb-auto">
        <div>
            <a href="/tinder" role="button">
                <img src="/assets/img/tinder_logo_blue.png" alt="Tinder | Dating, Make Friends & Meet New People | Welcome"
                     width="18%" height="18%" class="float-md-start d-inline-block align-text-top"></a>
            <nav class="nav nav-masthead justify-content-center float-md-end">
                <a href="/friends" role="button" class="nav-link py-1 px-0 active">Check your TinderS</a>
                <a class="nav-link py-1 px-0" href="">Safety</a>
                <a class="nav-link  py-1 px-0" href="">Support</a>
                <a class="nav-link py-1 px-0" href="">Features</a>
                <a href="/logout" role="button" class="nav-link py-1 px-0 active">log out</a>
            </nav>
        </div>
    </header>

    <main class="px-3">
        <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-arrow-through-heart" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M2.854 15.854A.5.5 0 0 1 2 15.5V14H.5a.5.5 0 0 1-.354-.854l1.5-1.5A.5.5 0 0 1 2 11.5h1.793l.53-.53c-.771-.802-1.328-1.58-1.704-2.32-.798-1.575-.775-2.996-.213-4.092C3.426 2.565 6.18 1.809 8 3.233c1.25-.98 2.944-.928 4.212-.152L13.292 2 12.147.854A.5.5 0 0 1 12.5 0h3a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-.854.354L14 2.707l-1.006 1.006c.236.248.44.531.6.845.562 1.096.585 2.517-.213 4.092-.793 1.563-2.395 3.288-5.105 5.08L8 13.912l-.276-.182a21.86 21.86 0 0 1-2.685-2.062l-.539.54V14a.5.5 0 0 1-.146.354l-1.5 1.5Zm2.893-4.894A20.419 20.419 0 0 0 8 12.71c2.456-1.666 3.827-3.207 4.489-4.512.679-1.34.607-2.42.215-3.185-.817-1.595-3.087-2.054-4.346-.761L8 4.62l-.358-.368c-1.259-1.293-3.53-.834-4.346.761-.392.766-.464 1.845.215 3.185.323.636.815 1.33 1.519 2.065l1.866-1.867a.5.5 0 1 1 .708.708L5.747 10.96Z"/>
        </svg>
        <h1 class="h3 font-weight-normal" style="margin-top: 0.5rem; margin-bottom: 1.5rem; color: #428dff;">Meet New People & Make Friends</h1>
        <#if users??>
            <div id="carouselExampleControls" class="carousel carousel-dark slide" data-bs-ride="false" data-bs-duration="false">
                <div class="carousel-inner">
                    <#list users as user>
                        <#if user?? && user?index == 0>
                            <div class="carousel-item active">
                                <div class="card mb-3 w-100">
                                    <div class="row g-0">
                                        <div class="col-md-6">
                                            <#if user.pictureSrc??>
                                                <div style="height: 400px;">
                                                    <img class="img-fluid mx-auto d-block bg-light" alt="avatar" src="${user.pictureSrc}" style="max-width: 100%; height: auto;"/>
                                                </div>
                                            <#else>
                                                <svg class="bd-placeholder-img img-fluid rounded-end" width="100%" height="400"
                                                     xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder:Image" preserveAspectRatio="xMidYMid slice" focusable="false">
                                                    <title>Placeholder</title><rect width="100%" height="100%" fill="#868e96"></rect>
                                                    <text x="50%" y="50%" fill="#dee2e6" dy=".3em">${user.userName} photo coming soon :)</text>
                                                </svg>
                                            </#if>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="card-body text-black bg-white" style="padding-bottom: 0;">
                                                <h5 class="">Hello, I'm ${user.userName}</h5>
                                                <p class="" style="min-height: 180px; height: fit-content">${user.aboutSelf}</p>
                                                <p class=""><small class="text-muted">${user.onlineStatus}</small></p>

                                                <div class="text-end sticky-bottom">
                                                    <a href="" class="btn btn-outline-secondary">DisLike</a>
                                                    <a href="" class="btn btn-outline-danger">Like</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        <#else>
                            <div class="carousel-item">
                                <div class="card mb-3 w-100">
                                    <div class="row g-0">
                                        <div class="col-md-6">
                                            <#if user.pictureSrc??>
                                                <div style="height: 400px;">
                                                    <img class="img-fluid mx-auto d-block bg-light" alt="avatar" src="${user.pictureSrc}" style="max-width: 100%; height: auto;"/>
                                                </div>
                                            <#else>
                                                <svg class="bd-placeholder-img img-fluid rounded-end" width="100%" height="400"
                                                     xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder:Image" preserveAspectRatio="xMidYMid slice" focusable="false">
                                                    <title>Placeholder</title><rect width="100%" height="100%" fill="#868e96"></rect>
                                                    <text x="50%" y="50%" fill="#dee2e6" dy=".3em">${user.userName} photo coming soon :)</text>
                                                </svg>
                                            </#if>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="card-body text-black bg-white" style="padding-bottom: 0;">
                                                <h5 class="">Hello, I'm ${user.userName}</h5>
                                                <p class="" style="min-height: 180px; height: fit-content">${user.aboutSelf}</p>
                                                <p class=""><small class="text-muted">${user.onlineStatus}</small></p>

                                                <div class="text-end sticky-bottom">
                                                    <a href="" class="btn btn-outline-secondary">DisLike</a>
                                                    <a href="" class="btn btn-outline-danger">Like</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </#if>
                    </#list>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </#if>
    </main>

    <footer class="mt-auto text-white-50">
        <p class="text-white-70">&copy; Tinder 2018</p>
    </footer>

</div>

<script src="/assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>



<#--    <#if users??>-->
<#--                <#list users as user>-->
<#--                    <#if user?? && user?index == 0>-->
<#--                        <p> name: ${user.userName}</p>-->
<#--                    <#else>-->
<#--                        <p> id: ${user.userId}</p>-->
<#--                    </#if>-->
<#--                </#list>-->
<#--     </#if>-->
