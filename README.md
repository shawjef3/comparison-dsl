# comparison-dsl
Provides &amp;&amp; and || operators for integers resulting from comparisons.

Instead of

```scala
if (c0 != 0) {
  c0
} else if (c1 != 0) {
  c1
} else c2
```

write

```scala
c0 && c1 && c2
```
.

Instead of

```scala
if (c0 == 0) {
  0
} else if (c1 == 0) {
  0
} else c2
```

write

```scala
c0 || c1 || c2
```
.
