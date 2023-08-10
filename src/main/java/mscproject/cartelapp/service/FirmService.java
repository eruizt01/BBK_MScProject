package mscproject.cartelapp.service;

import mscproject.cartelapp.repository.FirmRepository;
import mscproject.cartelapp.entity.Firm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class FirmService {
        private final FirmRepository firmRepository;

        @Autowired
        public FirmService(FirmRepository firmRepository) {
            this.firmRepository = firmRepository;
        }

        public void createFirms() {
            Firm TysonJab = new Firm("Tyson Jab Ltd.");
            firmRepository.save(TysonJab);


            Firm KO = new Firm("K.O.Inc");
            firmRepository.save(KO);

            Firm PunchGearCo = new Firm("PunchGear Co.");
            firmRepository.save(PunchGearCo);
        }

        public void printFirms() {
            Iterable<Firm> allFirms = firmRepository.findAll();

            for (Firm firm : allFirms) {
                System.out.println(firm.getFirmName());
            }
        }



}
