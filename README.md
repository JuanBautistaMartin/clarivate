## Alliteration exercise

Two methods were created in order to ge alliteration percentage info from a text:
* Get all the alliteration percentages from a text ordered desc
* Get the maximum alliteration percentage from a text

A simple RestController was created in order to test both methods:

```
URL: http://localhost:8080/alliteration/all

VERB: POST

Body: Yarvis yanked his ankle at yoga, and Yolanda yelled out in surprise.

Response:
y 41.67 %
a 25.00 %
s 8.33 %
h 8.33 %
i 8.33 %
o 8.33 %
```

```
URL: http://localhost:8080/alliteration/max

VERB: POST

Body: Yarvis yanked his ankle at yoga, and Yolanda yelled out in surprise.

Response:
y 41.67 %
```

## LoadBalancer exercise

A simple restController was created in order to test the service:

```
URL: http://localhost:8080/alliteration/all

VERB: POST

Body: [1,3,4,2,2,2,1,1,2]

Response:
true
```

```
URL: http://localhost:8080/alliteration/all

VERB: POST

Body: [1,1,1,1,1,1]

Response:
false
```

In this case unitary testing was created for the service but not for the controller because as 
an example of controller unit tests and integration tests were done for the previous exercise.