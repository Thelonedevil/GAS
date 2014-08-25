package com.github.thelonedevil.gearsautomatonssteam.tiles.machines.interfaces;

/**
 * Created by justin on 18/08/2014.
 */
public interface ITorquePowered {
    /**
     *
     * @return the minumum amount of torque required to function
     */
    public int getMinTorque();

    /**
     *
     * @return the maxium amount of torque machine can handle (will normally be MAX_INTEGER)
     */
    public int getMaxTorque();

    /**
     *
     * @return the current amount of torque
     */
    public int getCurrentTorque();
}
