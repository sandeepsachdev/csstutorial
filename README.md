# csstutorial

A Spring Boot application that doubles as an interactive **CSS tutorial**. It
covers CSS fundamentals, the box model, flexbox (with 16+ live examples), media
queries, and mobile-specific styling.

## Run it

```bash
mvn spring-boot:run
```

Then open <http://localhost:8080>.

## What's inside

| Route | Topic |
| --- | --- |
| `/` | Home — overview & links to each lesson |
| `/basics` | Selectors, cascade, specificity, colors, units, typography |
| `/box-model` | Margin/border/padding/content + `box-sizing` |
| `/flexbox` | 16 live flexbox examples (rows, justify, align, wrap, grow/shrink/basis, order, holy grail, navbar, centering, sticky footer) |
| `/media-queries` | Breakpoints, min-width vs max-width, `prefers-*` queries |
| `/mobile` | Viewport meta, mobile-first CSS, touch targets, safe-area insets, fluid type, hover/touch detection, dark mode |

## Project structure

```
src/main/java/com/example/csstutorial/
  CssTutorialApplication.java   # @SpringBootApplication entry point
  TutorialController.java       # routes each URL to a Thymeleaf template

src/main/resources/
  templates/                    # Thymeleaf pages + shared layout fragment
  static/css/
    main.css       # site chrome, typography, theme
    examples.css   # styles for every live demo
    mobile.css     # responsive rules + dark mode + reduced-motion + safe-areas
```

## Tips

- Resize the browser, or use Chrome DevTools' device toolbar
  (Cmd/Ctrl+Shift+M), to see the responsive demos react.
- Toggle your OS to dark mode — the whole site flips theme.
- Open `examples.css` and `mobile.css` side-by-side with the rendered pages
  to see exactly which rules produce each layout.
