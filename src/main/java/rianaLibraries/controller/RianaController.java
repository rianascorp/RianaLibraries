package rianaLibraries.controller;

import rianaLibraries.model.Models;

import java.io.IOException;

public interface RianaController {
       <M> void Initialize(Models<M> models) throws NoSuchMethodException, IOException;
}
