let mix = require('laravel-mix');
var tailwindcss = require('tailwindcss');

mix.options({
    processCssUrls: false
});

mix.js('frontend/app.js', 'src/main/webapp/js')
    .version();

mix.sass('frontend/sass/app.scss', 'src/main/webapp/css')
    .options({
        postCss: [
            tailwindcss('./tailwind-config.js'),
        ]
    })
    .version();
