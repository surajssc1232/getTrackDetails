# OkHttp Spotify API Example

This project demonstrates how to use the OkHttp library to interact with the Spotify API. It includes examples of fetching an access token and retrieving data for a specific track.

## Prerequisites

- Java 22
- Maven
- Spotify Developer Account

## Setup

1. **Clone the repository:**

    ```bash
    git clone <https://github.com/surajssc1232/getTrackDetails.git>
    cd <your-repo-directory>
    ```

2. **Configure Spotify API credentials:**

    Replace the `CLIENT_ID` and `CLIENT_SECRET` in `src/main/java/org/example/SpotifyAuth.java` with your Spotify API credentials.

3. **Build the project:**

    ```bash
    mvn clean install
    ```

## Usage

1. **Run the application:**

    ```bash
    mvn exec:java -Dexec.mainClass="org.example.SpotifyApiExample"
    ```

2. **Follow the prompts:**
   2. **Follow the prompts:**

    _Enter the track ID when prompted to fetch data for a specific track. 
    You can find the track ID in the Spotify app or web player by sharing the track and copying the Spotify URI. 
    The track ID is the part after `spotify:track:` in the URI._
    
    Enter the track ID when prompted to fetch data for a specific track.

## Dependencies

- [OkHttp](https://square.github.io/okhttp/) - HTTP & HTTP/2 client for Java
- [JSON](https://github.com/stleary/JSON-java) - A lightweight data interchange format

## License

This project is licensed under the MIT License.