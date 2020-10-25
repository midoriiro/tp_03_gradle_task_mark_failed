package com.yaps.petstore.domain.item;

import com.yaps.petstore.domain.DomainObject;
import com.yaps.petstore.domain.product.Product;
import com.yaps.petstore.exception.CheckException;

public class Item extends DomainObject
{
	// ======================================
	// =             Attributes             =
	// ======================================
	private String _id;
	private String _name;
	private double _unitCost;
	private Product _product;
	
	// ======================================
	// =            Constructors            =
	// ======================================
	public Item() {
	}
	
	public Item(final String id) {
		_id = id;
	}
	
	public Item(final String id, final String name, final double unitCost, final Product product) {
		_id = id;
		_name = name;
		_unitCost = unitCost;
		_product = product;
	}
	
	// ======================================
	// =            Private methods         =
	// ======================================
	
	// ======================================
	// =         Getters and Setters        =
	// ======================================
	public String getId() {
		return _id;
	}
	
	public String getName() {
		return _name;
	}
	
	public void setName(final String name) {
		_name = name;
	}
	
	public double getUnitCost() {
		return _unitCost;
	}
	
	public void setUnitCost(final double unitCost) { _unitCost = unitCost; }
	
	public Product getProduct()	{ return _product; }
	
	public void setProduct(final Product product) { _product = product; }
	
	/**
	 * This method checks the integrity of the object data.
	 *
	 * @throws CheckException if data is invalid
	 */
	public void checkData() throws CheckException {
		if (_name == null || "".equals(_name))
			throw new CheckException("Invalid name");
		if (_unitCost < 0)
			throw new CheckException("Invalid unit cost");
		if (_product == null || _product.getId() == null || "".equals(_product.getId()))
			throw new CheckException("Invalid product");
	}
	
	public String toString() {
		final StringBuffer buf = new StringBuffer();
		buf.append("\n\tItem {");
		buf.append("\n\t\tId=").append(_id);
		buf.append("\n\t\tName=").append(_name);
		buf.append("\n\t\tUnitCost=").append(_unitCost);
		buf.append("\n\t\tProduct Id=").append(_product.getId());
		buf.append("\n\t\tProduct Name=").append(_product.getName());
		buf.append("\n\t}");
		return buf.toString();
	}
}
