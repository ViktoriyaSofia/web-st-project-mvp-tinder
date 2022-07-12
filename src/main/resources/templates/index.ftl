<!doctype html>
<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">

    <title>Tinder | Dating, Make Friends & Meet New People | Welcome</title>

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

<body class="d-flex h-100 text-center text-white bg">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="mb-auto">
        <div>
            <#if isOnline??>
                <a href="/tinder" role="button">
                    <img src="/assets/img/tinder_logo_blue.png" alt="Tinder | Dating, Make Friends & Meet New People | Welcome"
                         width="18%" height="18%" class="float-md-start d-inline-block align-text-top">
                </a>
            <#else>
                <a href="/" role="button">
                    <img src="/assets/img/tinder_logo_white.png" alt="Tinder | Dating, Make Friends & Meet New People | Welcome"
                         width="18%" height="18%" class="float-md-start d-inline-block align-text-top">
                </a>
            </#if>
            <nav class="nav nav-masthead justify-content-center float-md-end">
                <a class="nav-link py-1 px-0" href="">Safety</a>
                <a class="nav-link  py-1 px-0" href="">Support</a>
                <a class="nav-link py-1 px-0" href="">Features</a>
                <a class="nav-link py-1 px-0" href="">Contact</a>
                <a class="nav-link py-1 px-0" href="">Download</a>
            <#if isOnline??>
                <a href="/logout" role="button" class="nav-link py-1 px-0 active">log out</a>
            <#else>
                <a href="/login" role="button" class="nav-link py-1 px-0 active">Log in</a>
            </#if>
            </nav>
        </div>
    </header>

    <main class="px-3">
        <h1 style="margin-top: 1.5rem; margin-bottom: 1.5rem;">Dating, Make Friends & Meet New People</h1>
        <#if isOnline??>
            <p class="lead">
                <a href="/profiles" role="button" class="btn btn-lg fw-bold border-white bg-black"
                   style="--bs-btn-color: #428dff; --bs-btn-hover-color: blueviolet;">Meet new people</a>
            </p>
        <#else>
            <p class="lead">
                <a href="/create" role="button" class="btn btn-lg fw-bold border-white bg-black"
                   style="--bs-btn-color: #428dff; --bs-btn-hover-color: blueviolet;">Create an account</a>
            </p>
        </#if>
    </main>

    <footer class="mt-auto text-white-50">
        <p class="text-white-70">&copy; Tinder 2018</p>
    </footer>
</div>

</body>
</html>