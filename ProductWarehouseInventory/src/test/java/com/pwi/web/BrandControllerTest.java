
package com.pwi.web;

import com.pwi.model.Brands;
import com.pwi.service.BrandService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BrandControllerTest {
    @Mock
    private BrandService brandService;

    private BrandRestController controller;

    private MockMvc mockMvc;

    private List<Brands> brandsList = asList(new Brands("1", "A", "Brand A"),
            new Brands("2", "A", "Brand B"));

    @Before
    public void init() {
        controller = new BrandRestController(brandService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    public void findBrandsByCompany() {
        Model model = new ExtendedModelMap();
        when(brandService.findBrandsByCompany("A")).thenReturn(brandsList);
        assertThat(controller.findAllBrandsByCompany("B"), equalTo(brandsList));
    }


}
