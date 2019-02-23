# {{name}}

FIXME: description

## Development

During development figwheel-main can be used by using cider's `cider-jack-in-cljs`.

Simply select `figwheel-main` and then enter `:dev` as the build config.

## Production build

To build the project for production simply run the following:

```bash
lein do clean,cljsbuild once min
```
