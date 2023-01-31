package com.example.application.views.idiom;

import com.example.application.data.entity.Idiom;
import com.example.application.data.service.IdiomService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Route(value = "/idiom", layout = MainLayout.class)
@PageTitle("Idiom List")
public class IdiomView extends VerticalLayout {
    private final IdiomService idiomService;

    Grid<Idiom> idiomGrid = new Grid<>(Idiom.class);

    private List<Idiom> idiomList = new ArrayList<>();

    public IdiomView(IdiomService idiomService) {
        this.idiomService = idiomService;
        setSizeFull();
        configureGrid();

        add(idiomGrid);

    }


    private void configureGrid() {
        getIdiomList();
        idiomGrid.setItems(idiomList);
        idiomGrid.addClassName("contact-grid");
        idiomGrid.setSizeFull();
        idiomGrid.setColumns("id", "polishMeaning", "englishMeaning", "englishExample", "audioTranslateLink", "audioExampleLink", "linkToIdiom");
        idiomGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        idiomGrid.getColumnByKey("id");
        idiomGrid.getColumnByKey("audioTranslateLink");
        idiomGrid.getColumnByKey("audioExampleLink");


    }

    private void getIdiomList() {
        if (idiomList.isEmpty()) {
            idiomList = idiomService.getIdioms();
        }


    }

}
