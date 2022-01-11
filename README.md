# VUI_Prototype

![Screenshot](screenshot.png)

## Requierements

- Docker
- Google Chrome (or any other `Speech Recognition Engine` compatible browser)

## Building and Running the service

**Build command**

```sh
docker build . -t vui_prototype
```

**Run command**

```sh
docker run --rm -it -p 6060:8080 vui_prototype
```

Open browser and go to: [https://localhost:6060](https://localhost:6060)

## Stopping the service

Stop the service with `Ctrl+C` in the console.
