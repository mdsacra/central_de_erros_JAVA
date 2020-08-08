package com.mdsacra.centraldeerros.endpoints.advice;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String ResourceName) {
            super("ATENÇÃO: " + ResourceName.toUpperCase() + " não encontrado!");
        }
}
