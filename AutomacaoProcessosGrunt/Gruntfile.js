module.exports = function(grunt) {
    grunt.initConfig({
       // configurações das tasks
       uglify: {
        options: {
         mangle: false
         },

        my_target: {
          files: [{
             expand: true,
             cwd: 'js/',
             src: '**/*.js',
             dest: 'buildGruntJS/',
             ext: '.min.js'
          }]
      }
     }
    });
  
    // carrega plugins
    grunt.loadNpmTasks('grunt-contrib-uglify');

    grunt.registerTask('default', ['uglify']);
  };
