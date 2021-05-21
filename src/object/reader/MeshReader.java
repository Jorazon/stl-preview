package object.reader;

import object.Mesh;

public interface MeshReader {
	
	public Mesh readMesh(String path);
	
}
