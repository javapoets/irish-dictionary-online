# Irish Dictionary Online

## Build Instructions


```
$ gradle clean build
```

### To build with Apache JSP support
```
gradle build -Papachejsp
```

### To perform a custom build based on a file in `/src/main/config`

```
gradle buildName -PbuildName=devenglishirish
```
