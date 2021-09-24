package agentes;

/* -*- mode: java; c-basic-offset: 2; indent-tabs-mode: nil -*- */
 /*
  Part of the Processing project - http://processing.org 
 
  Copyright (c) 200X Dan Shiffman 
  Copyright (c) 2008 Ben Fry and Casey Reas 
 
  This library is free software; you can redistribute it and/or 
  modify it under the terms of the GNU Lesser General Public 
  License as published by the Free Software Foundation; either 
  version 2.1 of the License, or (at your option) any later version. 
 
  This library is distributed in the hope that it will be useful, 
  but WITHOUT ANY WARRANTY; without even the implied warranty of 
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU 
  Lesser General Public License for more details. 
 
  You should have received a copy of the GNU Lesser General 
  Public License along with this library; if not, write to the 
  Free Software Foundation, Inc., 59 Temple Place, Suite 330, 
  Boston, MA  02111-1307  USA 
 */
/**
 * A class to describe a two or three dimensional vector.
 * <p>
 * The result of all functions are applied to the vector itself, with the
 * exception of cross(), which returns a new PVector (or writes to a specified
 * 'target' PVector). That is, add() will add the contents of one vector to this
 * one. Using add() with additional parameters allows you to put the result into
 * a new PVector. Functions that act on multiple vectors also include static
 * versions. Because creating new objects can be computationally expensive, most
 * functions include an optional 'target' PVector, so that a new PVector object
 * is not created with each operation.
 * <p>
 * Initially based on the Vector3D class by
 * <a href="http://www.shiffman.net">Dan Shiffman</a>.
 */
public class PVector {

    /**
     * The x component of the vector.
     */
    private float x;

    /**
     * The y component of the vector.
     */
    private float y;

    /**
     * The z component of the vector.
     */
    private float z;

    /**
     * Array so that this can be temporarily used in an array context
     */
    protected float[] array;

    /**
     * Constructor for an empty vector: x, y, and z are set to 0.
     */
    public PVector() {
    }

    /**
     * Constructor for a 3D vector.
     *
     * @param x the x coordinate.
     * @param y the y coordinate.
     * @param z the y coordinate.
     */
    public PVector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Constructor for a 2D vector: z coordinate is set to 0.
     *
     * @param x the x coordinate.
     * @param y the y coordinate.
     */
    public PVector(float x, float y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    /**
     * Set x, y, and z coordinates.
     *
     * @param x the x coordinate.
     * @param y the y coordinate.
     * @param z the z coordinate.
     */
    public void set(float x, float y, float z) {
        this.setX(x);
        this.setY(y);
        this.z = z;
    }

    /**
     * Set x, y, and z coordinates from a Vector3D object.
     *
     * @param v the PVector object to be copied
     */
    public void set(PVector v) {
        setX(v.getX());
        setY(v.getY());
        z = v.z;
    }

    /**
     * Set the x, y (and maybe z) coordinates using a float[] array as the
     * source.
     *
     * @param source array to copy from
     */
    public void set(float[] source) {
        if (source.length >= 2) {
            setX(source[0]);
            setY(source[1]);
        }
        if (source.length >= 3) {
            z = source[2];
        }
    }

    /**
     * Get a copy of this vector.
     * @return 
     */
    public PVector get() {
        return new PVector(getX(), getY(), z);
    }

    public float[] get(float[] target) {
        if (target == null) {
            return new float[]{getX(), getY(), z};
        }
        if (target.length >= 2) {
            target[0] = getX();
            target[1] = getY();
        }
        if (target.length >= 3) {
            target[2] = z;
        }
        return target;
    }

    /**
     * Calculate the magnitude (length) of the vector
     *
     * @return the magnitude of the vector
     */
    public float mag() {
        return (float) Math.sqrt(getX() * getX() + getY() * getY() + z * z);
    }

    /**
     * Add a vector to this vector
     *
     * @param v the vector to be added
     */
    public void add(PVector v) {
        setX(x + v.getX());
        setY(y + v.getY());
        z += v.z;
    }

    public void add(float x, float y, float z) {
        this.setX(this.x + x);
        this.setY(this.y + y);
        this.z += z;
    }

    /**
     * Add two vectors
     *
     * @param v1 a vector
     * @param v2 another vector
     * @return a new vector that is the sum of v1 and v2
     */
    static public PVector add(PVector v1, PVector v2) {
        return add(v1, v2, null);
    }

    /**
     * Add two vectors into a target vector
     *
     * @param v1 a vector
     * @param v2 another vector
     * @param target the target vector (if null, a new vector will be created)
     * @return a new vector that is the sum of v1 and v2
     */
    static public PVector add(PVector v1, PVector v2, PVector target) {
        if (target == null) {
            target = new PVector(v1.getX() + v2.getX(), v1.getY() + v2.getY(), v1.z + v2.z);
        } else {
            target.set(v1.getX() + v2.getX(), v1.getY() + v2.getY(), v1.z + v2.z);
        }
        return target;
    }

    /**
     * Subtract a vector from this vector
     *
     * @param v the vector to be subtracted
     */
    public void sub(PVector v) {
        setX(x - v.getX());
        setY(y - v.getY());
        z -= v.z;
    }

    public void sub(float x, float y, float z) {
        this.setX(this.x - x);
        this.setY(this.y - y);
        this.z -= z;
    }

    /**
     * Subtract one vector from another
     *
     * @param v1 a vector
     * @param v2 another vector
     * @return a new vector that is v1 - v2
     */
    static public PVector sub(PVector v1, PVector v2) {
        return sub(v1, v2, null);
    }

    static public PVector sub(PVector v1, PVector v2, PVector target) {
        if (target == null) {
            target = new PVector(v1.getX() - v2.getX(), v1.getY() - v2.getY(), v1.z - v2.z);
        } else {
            target.set(v1.getX() - v2.getX(), v1.getY() - v2.getY(), v1.z - v2.z);
        }
        return target;
    }

    /**
     * Multiply this vector by a scalar
     *
     * @param n the value to multiply by
     */
    public void mult(float n) {
        setX(x * n);
        setY(y * n);
        z *= n;
    }

    /**
     * Multiply a vector by a scalar
     *
     * @param v a vector
     * @param n scalar
     * @return a new vector that is v1 * n
     */
    static public PVector mult(PVector v, float n) {
        return mult(v, n, null);
    }

    /**
     * Multiply a vector by a scalar, and write the result into a target
     * PVector.
     *
     * @param v a vector
     * @param n scalar
     * @param target PVector to store the result
     * @return the target vector, now set to v1 * n
     */
    static public PVector mult(PVector v, float n, PVector target) {
        if (target == null) {
            target = new PVector(v.getX() * n, v.getY() * n, v.z * n);
        } else {
            target.set(v.getX() * n, v.getY() * n, v.z * n);
        }
        return target;
    }

    /**
     * Multiply each element of one vector by the elements of another vector.
     *
     * @param v the vector to multiply by
     */
    public void mult(PVector v) {
        setX(x * v.getX());
        setY(y * v.getY());
        z *= v.z;
    }

    /**
     * Multiply each element of one vector by the individual elements of another
     * vector, and return the result as a new PVector.
     * @param v1
     * @param v2
     * @return 
     */
    static public PVector mult(PVector v1, PVector v2) {
        return mult(v1, v2, null);
    }

    /**
     * Multiply each element of one vector by the individual elements of another
     * vector, and write the result into a target vector.
     *
     * @param v1 the first vector
     * @param v2 the second vector
     * @param target PVector to store the result
     * @return 
     */
    static public PVector mult(PVector v1, PVector v2, PVector target) {
        if (target == null) {
            target = new PVector(v1.getX() * v2.getX(), v1.getY() * v2.getY(), v1.z * v2.z);
        } else {
            target.set(v1.getX() * v2.getX(), v1.getY() * v2.getY(), v1.z * v2.z);
        }
        return target;
    }

    /**
     * Divide this vector by a scalar
     *
     * @param n the value to divide by
     */
    public void div(float n) {
        setX(x / n);
        setY(y / n);
        z /= n;
    }

    /**
     * Divide a vector by a scalar and return the result in a new vector.
     *
     * @param v a vector
     * @param n scalar
     * @return a new vector that is v1 / n
     */
    static public PVector div(PVector v, float n) {
        return div(v, n, null);
    }

    static public PVector div(PVector v, float n, PVector target) {
        if (target == null) {
            target = new PVector(v.getX() / n, v.getY() / n, v.z / n);
        } else {
            target.set(v.getX() / n, v.getY() / n, v.z / n);
        }
        return target;
    }

    /**
     * Divide each element of one vector by the elements of another vector.
     * @param v
     */
    public void div(PVector v) {
        setX(x / v.getX());
        setY(y / v.getY());
        z /= v.z;
    }

    /**
     * Multiply each element of one vector by the individual elements of another
     * vector, and return the result as a new PVector.
     * @param v1
     * @param v2
     * @return 
     */
    static public PVector div(PVector v1, PVector v2) {
        return div(v1, v2, null);
    }

    /**
     * Divide each element of one vector by the individual elements of another
     * vector, and write the result into a target vector.
     *
     * @param v1 the first vector
     * @param v2 the second vector
     * @param target PVector to store the result
     * @return 
     */
    static public PVector div(PVector v1, PVector v2, PVector target) {
        if (target == null) {
            target = new PVector(v1.getX() / v2.getX(), v1.getY() / v2.getY(), v1.z / v2.z);
        } else {
            target.set(v1.getX() / v2.getX(), v1.getY() / v2.getY(), v1.z / v2.z);
        }
        return target;
    }

    /**
     * Calculate the Euclidean distance between two points (considering a point
     * as a vector object)
     *
     * @param v another vector
     * @return the Euclidean distance between
     */
    public float dist(PVector v) {
        float dx = getX() - v.getX();
        float dy = getY() - v.getY();
        float dz = z - v.z;
        return (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * Calculate the Euclidean distance between two points (considering a point
     * as a vector object)
     *
     * @param v1 a vector
     * @param v2 another vector
     * @return the Euclidean distance between v1 and v2
     */
    static public float dist(PVector v1, PVector v2) {
        float dx = v1.getX() - v2.getX();
        float dy = v1.getY() - v2.getY();
        float dz = v1.z - v2.z;
        return (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * Calculate the dot product with another vector
     *
     * @param v
     * @return the dot product
     */
    public float dot(PVector v) {
        return getX() * v.getX() + getY() * v.getY() + z * v.z;
    }

    public float dot(float x, float y, float z) {
        return this.getX() * x + this.getY() * y + this.z * z;
    }

    static public float dot(PVector v1, PVector v2) {
        return v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.z * v2.z;
    }

    /**
     * Return a vector composed of the cross product between this and another.
     * @param v
     * @return 
     */
    public PVector cross(PVector v) {
        return cross(v, null);
    }

    /**
     * Perform cross product between this and another vector, and store the
     * result in 'target'. If target is null, a new vector is created.
     * @param v
     * @param target
     * @return 
     */
    public PVector cross(PVector v, PVector target) {
        float crossX = getY() * v.z - v.getY() * z;
        float crossY = z * v.getX() - v.z * getX();
        float crossZ = getX() * v.getY() - v.getX() * getY();

        if (target == null) {
            target = new PVector(crossX, crossY, crossZ);
        } else {
            target.set(crossX, crossY, crossZ);
        }
        return target;
    }

    static public PVector cross(PVector v1, PVector v2, PVector target) {
        float crossX = v1.getY() * v2.z - v2.getY() * v1.z;
        float crossY = v1.z * v2.getX() - v2.z * v1.getX();
        float crossZ = v1.getX() * v2.getY() - v2.getX() * v1.getY();

        if (target == null) {
            target = new PVector(crossX, crossY, crossZ);
        } else {
            target.set(crossX, crossY, crossZ);
        }
        return target;
    }

    /**
     * Normalize the vector to length 1 (make it a unit vector)
     */
    public void normalize() {
        float m = mag();
        if (m != 0 && m != 1) {
            div(m);
        }
    }

    /**
     * Normalize this vector, storing the result in another vector.
     *
     * @param target Set to null to create a new vector
     * @return a new vector (if target was null), or target
     */
    public PVector normalize(PVector target) {
        if (target == null) {
            target = new PVector();
        }
        float m = mag();
        if (m > 0) {
            target.set(getX() / m, getY() / m, z / m);
        } else {
            target.set(getX(), getY(), z);
        }
        return target;
    }

    /**
     * Limit the magnitude of this vector
     *
     * @param max the maximum length to limit this vector
     */
    public void limit(float max) {
        if (mag() > max) {
            normalize();
            mult(max);
        }
    }

    /**
     * Calculate the angle of rotation for this vector (only 2D vectors)
     *
     * @return the angle of rotation
     */
    public float heading2D() {
        float angle = (float) Math.atan2(-getY(), getX());
        return -1 * angle;
    }

    /**
     * Calculate the angle between two vectors, using the dot product
     *
     * @param v1 a vector
     * @param v2 another vector
     * @return the angle between the vectors
     */
    static public float angleBetween(PVector v1, PVector v2) {
        double dot = v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.z * v2.z;
        double v1mag = Math.sqrt(v1.getX() * v1.getX() + v1.getY() * v1.getY() + v1.z * v1.z);
        double v2mag = Math.sqrt(v2.getX() * v2.getX() + v2.getY() * v2.getY() + v2.z * v2.z);
        return (float) Math.acos(dot / (v1mag * v2mag));
    }

    @Override
    public String toString() {
        return "[ " + getX() + ", " + getY() + ", " + z + " ]";
    }

    /**
     * Return a representation of this vector as a float array. This is only for
     * temporary use. If used in any other fashion, the contents should be
     * copied by using the get() command to copy into your own array.
     * @return 
     */
    public float[] array() {
        if (array == null) {
            array = new float[3];
        }
        array[0] = getX();
        array[1] = getY();
        array[2] = z;
        return array;
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }
}
