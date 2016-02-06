package mas.shaders;

import org.lwjgl.util.vector.Matrix4f;

import mas.MAS;
import mas.render.Camera;
import mas.utils.MathUtils;

/**
 * @author SCAREX
 *
 */
public class BasicShader extends ShaderProgram
{
    protected int loc_offsetMatrix;
    protected int loc_transformationMatrix;
    protected int loc_projectionMatrix;
    protected int loc_viewMatrix;

    public BasicShader() {
        super(MAS.class.getResourceAsStream("shaders/vertexShader.glsl"), MAS.class.getResourceAsStream("shaders/fragmentShader.glsl"));
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "pos");
        super.bindAttribute(1, "textureCoords");
    }

    @Override
    protected void getAllUniformLocations() {
        this.loc_offsetMatrix = super.getUniformLocation("offsetMatrix");
        this.loc_transformationMatrix = super.getUniformLocation("transformationMatrix");
        this.loc_projectionMatrix = super.getUniformLocation("projectionMatrix");
        this.loc_viewMatrix = super.getUniformLocation("viewMatrix");
    }
    
    public void loadOffsetMatrix(Matrix4f matrix) {
        super.loadMatrix(this.loc_offsetMatrix, matrix);
    }

    public void loadTransformationMatrix(Matrix4f matrix) {
        super.loadMatrix(this.loc_transformationMatrix, matrix);
    }

    public void loadProjectionMatrix(Matrix4f m) {
        super.loadMatrix(this.loc_projectionMatrix, m);
    }

    public void loadViewMatrix(Camera c) {
        super.loadMatrix(this.loc_viewMatrix, MathUtils.createViewMatrix(c));
    }
}
