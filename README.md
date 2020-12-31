# Irish Dictionary Online

## Build Instructions


```
$ gradle clean build
```

### To perform a custom build based on a file in `/src/main/config`
```
dev.englishirishdictionary.com:
gradle buildName -PbuildName=devenglishirish

www.englishirishdictionary.com:
gradle buildName -PbuildName=prodenglishirish

### To add Apache JSP support for non Gretty builds
```
gradle build -Papachejsp
```
