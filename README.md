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

