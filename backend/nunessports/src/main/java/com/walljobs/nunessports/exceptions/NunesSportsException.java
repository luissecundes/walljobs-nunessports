package com.walljobs.nunessports.exceptions;

public class NunesSportsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NunesSportsException(String message) {
		super(message);
	}

	public static class ProductsNotFoundException extends NunesSportsException {
		private static final long serialVersionUID = 1L;

		public ProductsNotFoundException() {
			super("Não foi possível encontrar a lista de produtos.");
		}
	}
	public static class ProductsNotFoundIdException extends NunesSportsException {
		private static final long serialVersionUID = 1L;

		public ProductsNotFoundIdException(long l) {
			super("Não foi possível encontrar a lista de produtos.");
		}
	}

	public static class ProductNotSavedException extends NunesSportsException {
		private static final long serialVersionUID = 1L;
		public ProductNotSavedException() {
			super("Não foi possível salvar o produto na base de dados.");
		}
	}

	public static class ProductNotUpdatedException extends NunesSportsException {
		private static final long serialVersionUID = 1L;
		public ProductNotUpdatedException(Long productId) {
			super("Não foi possível atualizar o produto com ID " + productId + ".");
		}
	}

	public static class ProductNotDeletedException extends NunesSportsException {
		private static final long serialVersionUID = 1L;
		public ProductNotDeletedException(Long productId) {
			super("Não foi possível excluir o produto com ID: " + productId + ".");
		}
	}
}
