package mindustry.graphics.g3d;

import arc.graphics.gl.*;
import arc.math.geom.*;
import mindustry.graphics.*;
import mindustry.type.*;

public class HexMesh extends PlanetMesh{

    public HexMesh(Planet planet, int divisions){
        super(planet, MeshBuilder.buildHex(planet.generator, divisions, planet.radius, 0.2f), Shaders.planet);
    }

    public HexMesh(Planet planet, HexMesher mesher, int divisions, Shader shader){
        super(planet, MeshBuilder.buildHex(mesher, divisions, planet.radius, 0.2f), shader);
    }

    public HexMesh(){
    }

    @Override
    public void preRender(PlanetParams params){
        Shaders.planet.planet = planet;
        Shaders.planet.emissive = planet.generator != null && planet.generator.isEmissive();
        Shaders.planet.lightDir.set(planet.solarSystem.position).sub(planet.position).rotate(Vec3.Y, planet.getRotation()).nor();
        Shaders.planet.ambientColor.set(planet.solarSystem.lightColor);
    }
}
