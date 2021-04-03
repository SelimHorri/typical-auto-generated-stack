import * as dayjs from 'dayjs';

export interface IEmployee {
  id?: number;
  employeeId?: number;
  firstname?: string | null;
  lastName?: string | null;
  hiredate?: dayjs.Dayjs | null;
}

export class Employee implements IEmployee {
  constructor(
    public id?: number,
    public employeeId?: number,
    public firstname?: string | null,
    public lastName?: string | null,
    public hiredate?: dayjs.Dayjs | null
  ) {}
}

export function getEmployeeIdentifier(employee: IEmployee): number | undefined {
  return employee.id;
}
