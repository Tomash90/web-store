package com.packt.webstore.domain.DTO;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import com.packt.webstore.validator.Category;
import com.packt.webstore.validator.ProductId;

public class ProductDTO {
	@Pattern(regexp="D[0-9]+", message="{Pattern.Product.productId.validation}")
	@ProductId
	private String productId;
	@Size(min=4,max=50,message="{Size.Product.name.validation}")
	private String name;
	@Min(value=0, message="{Min.Product.unitPrice.validation}")
	@Digits(integer=6, fraction=2,message="{Digits.Product.unitPrice.validation}")
	@NotNull(message="{NotNull.Product.unitPrice.validation}")
	private BigDecimal unitPrice;
	private String description;
	private String manufacturer;
	@NotNull(message="{NotNull.Product.category.validation}")
	@Category(allowedCategories = {"RTS", "RPG", "FPS"})
	private String category;
	@Min(value = 0, message="{Min.Product.unitsInStock.validation}")
	private long unitsInStock;
	private long unitsInOrder;
	private boolean discontinued;
	private String condition;
	private MultipartFile productImage;
		
		public ProductDTO(){
			super();
		}
		
		public ProductDTO(String productId, String name, BigDecimal unitPrice){
			this.productId = productId;
			this.name = name;
			this.unitPrice = unitPrice;
		}

		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public BigDecimal getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(BigDecimal unitPrice) {
			this.unitPrice = unitPrice;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public long getUnitsInStock() {
			return unitsInStock;
		}

		public void setUnitsInStock(long unitsInStock) {
			this.unitsInStock = unitsInStock;
		}

		public long getUnitsInOrder() {
			return unitsInOrder;
		}

		public void setUnitsInOrder(long unitsInOrder) {
			this.unitsInOrder = unitsInOrder;
		}

		public boolean isDiscontinued() {
			return discontinued;
		}

		public void setDiscontinued(boolean discontinued) {
			this.discontinued = discontinued;
		}

		public String getCondition() {
			return condition;
		}

		public void setCondition(String condition) {
			this.condition = condition;
		}
		
		public MultipartFile getProductImage() {
			return productImage;
		}
		public void setProductImage(MultipartFile productImage) {
			this.productImage = productImage;
		}
	}

