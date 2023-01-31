package com.example.application.views.phrasal;

import com.example.application.data.entity.Phrasal;
import com.example.application.data.service.PhrasalService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Route(value = "/phrasal", layout = MainLayout.class)
@PageTitle("Phrasal List")
public class PhrasalView extends VerticalLayout {

    private final PhrasalService phrasalService;

    Grid<Phrasal> phrasalViewGrid = new Grid<>(Phrasal.class);

    private List<Phrasal> phrasalList = new ArrayList<>();

    public PhrasalView(PhrasalService phrasalService) {
        this.phrasalService = phrasalService;
        setSizeFull();
        configureGrid();

        add(phrasalViewGrid);
    }

    private void configureGrid() {
        getPhrasalList();
        phrasalViewGrid.setItems(phrasalList);
        phrasalViewGrid.addClassName("contact-grid");
        phrasalViewGrid.setSizeFull();
        phrasalViewGrid.setColumns("id", "polishMeaning", "englishMeaning", "englishExample", "linkToPhrasalVerb");
        phrasalViewGrid.setSelectionMode(Grid.SelectionMode.SINGLE);

    }

    private void getPhrasalList() {
        if (phrasalList.isEmpty()) {
            phrasalList=phrasalService.getPhrasals();
        }
    }
}
