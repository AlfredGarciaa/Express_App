package edu.bo.ucb.express_app.Domain.UseCase

import edu.bo.ucb.express_app.Data.Result
import edu.bo.ucb.express_app.Domain.Model.Characters
import edu.bo.ucb.express_app.Domain.Repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
    ) {
        operator fun invoke(page: Int): Flow<Result<List<Characters>>> {
            return repository.getCharacters(page)
        }
    }