package com.idnp.openglsample;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;

public class GLClearRenderer implements Renderer {

    private Cube cube = new Cube();
    private Pyramid pyramid= new Pyramid();
    private float cubeRotation,pyramidRotation;

    public void onDrawFrame( GL10 gl ) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        gl.glTranslatef(-1.5f, 0.0f, -6.0f);
        gl.glRotatef(cubeRotation, 1.0f, 1.0f, 1.0f);
        cube.draw(gl);
        gl.glLoadIdentity();

        gl.glTranslatef(1.5f, 0.0f, -6.0f);
        gl.glRotatef(pyramidRotation, -1.0f, -1.0f, -1.0f);
        pyramid.draw(gl);
        gl.glLoadIdentity();

        cubeRotation -= 0.50f;
        pyramidRotation -= 0.50f;
    }

    public void onSurfaceChanged( GL10 gl, int width, int height ) {
        gl.glViewport( 0, 0, width, height );
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 45.0f, (float)width / (float)height, 0.1f, 100.0f);
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void onSurfaceCreated( GL10 gl, EGLConfig config ) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,
                GL10.GL_NICEST);
    }
}